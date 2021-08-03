package ru.lakeev.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Metro implements Serializable {

  private List<Line> lines;
  private ArrayList<Connection> connections;

  public void addLine(Line line) {
    lines.add(line);
  }

  public void addConnection(Connection connection) {
    connections.add(connection);
  }
}
