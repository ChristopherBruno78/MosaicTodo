package com.cocoawerks.mosaictodo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Entry implements EntryPoint {

  @Override
  public void onModuleLoad() {
    RootPanel.get().add(new TodoInterface());
  }
}
