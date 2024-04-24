package com.ejemplo.miapp.ui;

import java.io.IOException;
import java.util.function.BiConsumer;

import com.ejemplo.miapp.User;

public class Option implements Displayable {
  private String name;
  private int number;
  private BiConsumer<Menu, User> onSelection;

  public Option(String name, int number) {
    this.name = name;
    this.number = number;
  }

  @Override
  public void display() {
    System.out.println(this.number + "- " + this.name);
  }

  public int getNumber() {
    return this.number;
  }

  public void defineOnSelection(BiConsumer<Menu, User> consumer) {
    this.onSelection = consumer;
  }

  public void select(Menu menu, User user) {
    if (this.isActionable() == false) {
      System.err.println("onSelection method is not defined for option " + this.name);
      return;
    }
    this.onSelection.accept(menu, user);
  }

  public boolean isActionable() {
    return this.onSelection != null;
  }
}
