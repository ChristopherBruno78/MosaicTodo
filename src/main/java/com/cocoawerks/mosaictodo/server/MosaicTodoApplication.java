package com.cocoawerks.mosaictodo.server;

import com.cocoawerks.mosaic.server.MosaicServletInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@EntityScan("com.cocoawerks.mosaictodo.shared")
public class MosaicTodoApplication extends MosaicServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(MosaicTodoApplication.class, args);
  }
}
