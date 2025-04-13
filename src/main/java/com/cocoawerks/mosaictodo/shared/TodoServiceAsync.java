package com.cocoawerks.mosaictodo.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface TodoServiceAsync {
  void createTodo(Todo todo, AsyncCallback<Todo> async);

  void getTodos(AsyncCallback<List<Todo>> async);

  void removeTodo(Todo todo, AsyncCallback<Void> async);

  void updateTodo(Todo todo, AsyncCallback<Void> async);
}
