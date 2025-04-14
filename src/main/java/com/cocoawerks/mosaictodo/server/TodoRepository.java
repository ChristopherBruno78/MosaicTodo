package com.cocoawerks.mosaictodo.server;

import com.cocoawerks.mosaictodo.shared.Todo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
  Optional<Todo> findByTitle(String title);
}
