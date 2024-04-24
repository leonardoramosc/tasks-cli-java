package com.ejemplo.miapp.ui;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import com.ejemplo.miapp.User;

public class Menu implements Displayable {
  private String header;
  private ArrayList<Option> options;
  private Scanner scanner;
  private User currentUser;

  public Menu(String header, Scanner scanner, User currentUser) {
    this.header = header;
    this.options = new ArrayList<>();
    this.scanner = scanner;
    this.currentUser = currentUser;
  }

  @Override
  public void display() {
    if (this.options.isEmpty()) {
      System.out.println("You need to add options to be able display this menu");
      return;
    }

    System.out.println("--------------------------------------------");
    System.out.println(this.header);
    this.options.forEach((option) -> option.display());
    System.out.println("--------------------------------------------");

    try {
      String optionStr = this.scanner.nextLine();
      int option = Integer.parseInt(optionStr);
      this.selectOption(option, this.currentUser);
    } catch (NumberFormatException e) {
      this.showInvalidOptionSelectedMessage();
    }
  }

  public void addOption(Option option) {
    if (option.isActionable() == false) {
      System.err.println("Make sure you made this option actionable by defining the onSelection method");
      return;
    }
    this.options.add(option);
  }

  public void selectOption(int optionNumber, User currentUser) {
    Optional<Option> result = this.options.stream().filter(o -> o.getNumber() == optionNumber).findFirst();

    if (result.isPresent() == false) {
      this.showInvalidOptionSelectedMessage();
    }

    Option option = result.get();

    option.select(this, currentUser);
  }

  private void showInvalidOptionSelectedMessage() {
    System.out.println("Por favor ingresa una opcion valida");
    this.display();
  }
}
