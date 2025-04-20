package com.cocoawerks.mosaictodo.client;

import com.cocoawerks.simplerouter.client.Router;
import com.google.gwt.core.client.EntryPoint;

public class Entry implements EntryPoint {
  final Router router = Router.get();

  @Override
  public void onModuleLoad() {
    router.install();
    router.setNotFoundView(new NotFoundView());
    router.mapRoute("/todo", new TodoInterface());
  }
}
