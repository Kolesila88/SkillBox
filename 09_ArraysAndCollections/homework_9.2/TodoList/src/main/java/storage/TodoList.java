package storage;

import java.math.BigInteger;
import java.util.ArrayList;

public class TodoList {

  private ArrayList<String> toDoList;

  public TodoList() {

    toDoList = new ArrayList<>();
  }

  public void add(String todo) {

    toDoList.add(todo);
  }

  public void add(int index, String todo) {

    if (toDoList.size() > index && index >= BigInteger.ZERO.intValue()) {

      toDoList.add(index, todo);
    } else {

      toDoList.add(todo);
    }
  }

  public void edit(String todo, int index) {

    if (index < toDoList.size() && index >= BigInteger.ZERO.intValue()) {

      toDoList.set(index, todo);
    }
  }

  public void delete(int index) {

    if (index < toDoList.size() && index >= BigInteger.ZERO.intValue()) {

      toDoList.remove(index);
    }
  }

  public ArrayList<String> getTodo() {

    return toDoList;
  }
}