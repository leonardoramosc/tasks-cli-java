package com.ejemplo.miapp;

import java.util.ArrayList;

public class User {
  private String username;
  private ArrayList<Task> tasks;

  public User(String username) {
    this.username = username;
    this.tasks = new ArrayList<>();
  }

  public String getUserName() {
    return this.username;
  }

  public void addTask(Task task) {
    this.tasks.add(task);
  }

  public void addTasks(ArrayList<Task> tasks) {
    this.tasks.addAll(tasks);
  }

  public Task getTask(int index) {
    return this.tasks.get(index);
  }

  public void describeTasks() {
    if (this.tasks.isEmpty()) {
      System.out.println("No tienes tareas por hacer :)");
      return;
    }
    System.out.println(username + " Tiene que completar las siguientes tareas:");
    
    this.tasks.forEach((task) -> {
      String msg = "- " + task.getTitle();
      System.out.println(msg);
    });
  }
}
