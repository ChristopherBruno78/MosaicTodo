package com.cocoawerks.mosaictodo.server;

import com.cocoawerks.mosaic.server.MosaicServletInitializer;
import com.cocoawerks.mosaictodo.shared.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@EntityScan("com.cocoawerks.mosaictodo.shared")
public class MosaicTodoApplication
  extends MosaicServletInitializer
  implements CommandLineRunner {
  @Autowired
  private TodoRepository todoRepository;

  public static void main(String[] args) {
    SpringApplication.run(MosaicTodoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Todo todo = new Todo("Wake up");
    todoRepository.save(todo);
  }
}
