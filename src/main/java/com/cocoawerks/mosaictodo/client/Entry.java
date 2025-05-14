package com.cocoawerks.mosaictodo.client;

import com.cocoawerks.mosaic.client.router.Router;
import com.google.gwt.core.client.EntryPoint;

public class Entry implements EntryPoint {
  final Router router = Router.create();

  @Override
  public void onModuleLoad() {
    router.route("/", new TodoInterface());
  }
}
