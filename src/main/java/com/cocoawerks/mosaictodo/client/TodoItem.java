package com.cocoawerks.mosaictodo.client;

import static elemental2.dom.DomGlobal.console;

import com.cocoawerks.mosaic.widgets.client.ui.CheckBox;
import com.cocoawerks.mosaictodo.shared.Todo;
import com.cocoawerks.mosaictodo.shared.TodoService;
import com.cocoawerks.mosaictodo.shared.TodoServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class TodoItem extends Composite {

  interface TodoItemUiBinder extends UiBinder<FlowPanel, TodoItem> {}

  private static TodoItemUiBinder ourUiBinder = GWT.create(
    TodoItemUiBinder.class
  );

  private final TodoServiceAsync todoService = GWT.create(TodoService.class);

  @UiField
  CheckBox label;

  private Todo todo;

  public TodoItem(Todo item) {
    this.todo = item;

    initWidget(ourUiBinder.createAndBindUi(this));

    this.label.setValue(item.isCompleted());
    this.label.setText(item.getTitle());
  }

  public String getTitle() {
    return this.label.getText();
  }

  @UiHandler("label")
  void onLabelClick(ClickEvent event) {
    this.todo.setCompleted(this.label.getValue());
    todoService.updateTodo(
      this.todo,
      new AsyncCallback<Void>() {

        @Override
        public void onFailure(Throwable throwable) {}

        @Override
        public void onSuccess(Void unused) {
          console.log("Todo updated.");
        }
      }
    );
  }
}
