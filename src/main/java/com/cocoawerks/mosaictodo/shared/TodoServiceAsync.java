package com.cocoawerks.mosaictodo.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;

public interface TodoServiceAsync {
  void createTodo(Todo todo, AsyncCallback<Todo> async);

  void getTodos(AsyncCallback<List<Todo>> async);
}
