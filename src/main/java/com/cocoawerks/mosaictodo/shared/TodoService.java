package com.cocoawerks.mosaictodo.shared;

import com.cocoawerks.mosaic.shared.ServerException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("todo")
public interface TodoService extends RemoteService {
  Todo createTodo(Todo todo) throws ServerException;

  void updateTodo(Todo todo) throws ServerException;

  void removeTodo(Todo todo) throws ServerException;

  List<Todo> getTodos() throws ServerException;
}
