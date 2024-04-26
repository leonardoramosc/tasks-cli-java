package com.ejemplo.miapp;

import java.util.Scanner;

import com.ejemplo.miapp.ui.TasksMenu;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter username:");

    String username = scanner.nextLine();

    User user = new User(username);

    System.out.println("Bienvenido " + user.getUserName());
    TasksMenu taskMenu = new TasksMenu(scanner, user);

    taskMenu.initialize();
    
    scanner.close();
  }
}