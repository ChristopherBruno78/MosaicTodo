package com.cocoawerks.mosaictodo.client;

import static elemental2.dom.DomGlobal.console;

import com.cocoawerks.mosaic.client.router.ViewController;
import com.cocoawerks.mosaic.widgets.client.events.edited.EditedEvent;
import com.cocoawerks.mosaic.widgets.client.ui.TextField;
import com.cocoawerks.mosaictodo.shared.Todo;
import com.cocoawerks.mosaictodo.shared.TodoService;
import com.cocoawerks.mosaictodo.shared.TodoServiceAsync;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.file.client.FileReader;
import com.google.gwt.file.client.FileReaderMode;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;

public class TodoInterface extends Composite implements ViewController {

  interface TodoInterfaceUiBinder
    extends UiBinder<VerticalPanel, TodoInterface> {}

  private static final TodoInterfaceUiBinder ourUiBinder = GWT.create(
    TodoInterfaceUiBinder.class
  );

  private final TodoServiceAsync todoService = GWT.create(TodoService.class);

  public TodoInterface() {
    initWidget(ourUiBinder.createAndBindUi(this));
    syncTodoList();
  }

  @Override
  public Widget getView() {
    return this;
  }

  @UiField
  TextField todoTitleField;

  @UiField
  VerticalPanel todoList;

  @UiHandler("todoTitleField")
  void onEnterInput(EditedEvent event) {
    createTodo();
  }

  @UiHandler("addButton")
  void onAddButton(ClickEvent event) {
    createTodo();
  }

  void createTodo() {
    String newTitle = todoTitleField.getValue();
    if (!newTitle.isBlank()) {
      todoService.createTodo(
        new Todo(newTitle),
        new AsyncCallback<>() {

          @Override
          public void onFailure(Throwable throwable) {
            Window.alert(throwable.getMessage());
          }

          @Override
          public void onSuccess(Todo todo) {
            if (todo != null) {
              todoTitleField.setValue("");
              todoTitleField.setFocus(true);
              syncTodoList();
            }
          }
        }
      );
    }
  }

  void syncTodoList() {
    todoList.clear();
    todoService.getTodos(
      new AsyncCallback<>() {

        @Override
        public void onFailure(Throwable throwable) {}

        @Override
        public void onSuccess(List<Todo> todos) {
          for (Todo todo : todos) {
            TodoItem item = new TodoItem(todo);
            todoList.add(item);
          }
        }
      }
    );
  }
}
