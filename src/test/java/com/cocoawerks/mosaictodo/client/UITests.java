package com.cocoawerks.mosaictodo.client;

import com.cocoawerks.mosaictodo.shared.Todo;
import com.google.gwt.junit.client.GWTTestCase;

public class UITests extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.cocoawerks.mosaictodo.MosaicTodo";
  }

  public void testTodoItem() {
    Todo todo = new Todo();
    todo.setTitle("Test");
    TodoItem item = new TodoItem(todo);
    assertEquals("Test", item.getTitle());

  }
}
