package com.ejemplo.miapp.ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BiConsumer;

import com.ejemplo.miapp.Task;
import com.ejemplo.miapp.User;

public class TasksMenu {
  private Menu menu;
  private Scanner scanner;
  private User user;

  public TasksMenu(Scanner scanner, User user) {
    this.scanner = scanner;
    this.user = user;
    this.menu = new Menu("¿Qué deseas hacer?", this.scanner, this.user);
  }

  public void initialize() {
    ArrayList<Option> options = this.createOptions();

    options.forEach(option -> {
      this.menu.addOption(option);
    });

    this.menu.display();
  }

  private ArrayList<Option> createOptions() {
    ArrayList<Option> options = new ArrayList<>();
    Option addTaskOption = this.createAddTaskOption();
    Option listTasksOption = this.createListTasksOption();
    
    options.add(addTaskOption);
    options.add(listTasksOption);

    return options;
  }

  private Option createAddTaskOption() {
    Option option = new Option("Agregar tarea", 1);

    BiConsumer<Menu, User> addTask = (menu, user) -> {
      System.out.println("Ingresa el nombre de tu tarea");
      String taskTitle = this.scanner.nextLine();
      
      user.addTask(new Task(taskTitle));
      System.out.println("Tarea agregada exitosamente!");

      this.menu.display();
    };

    option.defineOnSelection(addTask);

    return option;
  }

  private Option createListTasksOption() {
    Option option = new Option("Ver mis tareas", 2);

    BiConsumer<Menu, User> listTasks = (menu, user) -> {
      user.describeTasks();
      this.menu.display();
    };

    option.defineOnSelection(listTasks);

    return option;
  }
}
