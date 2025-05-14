package com.cocoawerks.mosaictodo.server;

import com.cocoawerks.mosaictodo.shared.Todo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
  Optional<Todo> findByTitle(String title);
}
