package com.cocoawerks.mosaictodo.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo implements IsSerializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String title;

  @Column(nullable = true)
  private String description;

  @Column(nullable = false)
  private boolean completed = false;

  public Todo() {}

  public Todo(String title) {
    this.title = title;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}
