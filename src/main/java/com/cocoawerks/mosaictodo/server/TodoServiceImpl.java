package com.cocoawerks.mosaictodo.server;

import com.cocoawerks.mosaic.shared.ServerException;
import com.cocoawerks.mosaictodo.shared.Todo;
import com.cocoawerks.mosaictodo.shared.TodoService;
import com.google.gwt.user.server.rpc.jakarta.RemoteServiceServlet;
import jakarta.servlet.annotation.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@WebServlet("/gwt/todo")
public class TodoServiceImpl
  extends RemoteServiceServlet
  implements TodoService {
  @Autowired
  private TodoRepository todoRepository;

  @Override
  public Todo createTodo(Todo todo) throws ServerException {
    Optional<Todo> duplicate = todoRepository.findTodoByTitle(todo.getTitle());
    if (duplicate.isPresent()) {
      throw new ServerException("Duplicate Todo");
    }
    todoRepository.save(todo);
    return todo;
  }

  @Override
  public void updateTodo(Todo todo) throws ServerException {
    Optional<Todo> duplicate = todoRepository.findTodoById(todo.getId());
    if (duplicate.isPresent()) {
      todoRepository.save(todo);
    } else {
      throw new ServerException("Todo Not Found");
    }
  }

  @Override
  public void removeTodo(Todo todo) throws ServerException {
    Optional<Todo> duplicate = todoRepository.findTodoById(todo.getId());
    if (duplicate.isPresent()) {
      todoRepository.delete(duplicate.get());
    } else {
      throw new ServerException("Todo Not Found");
    }
  }

  @Override
  public List<Todo> getTodos() throws ServerException {
    return todoRepository.findAll();
  }
}
