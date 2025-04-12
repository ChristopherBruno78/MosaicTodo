package com.cocoawerks.mosaictodo.server;

import com.cocoawerks.mosaictodo.shared.Todo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
  Optional<Todo> findTodoById(Long id);

  Optional<Todo> findTodoByTitle(String title);

  List<Todo> findAll();
}
