#!/bin/bash

javac -d bin -sourcepath src -cp lib/* src/com/ejemplo/miapp/Main.java

java -cp bin:lib/* com.ejemplo.miapp.Main