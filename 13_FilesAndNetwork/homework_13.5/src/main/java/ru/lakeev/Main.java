package ru.lakeev;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import ru.lakeev.calculator.RouteCalculator;
import ru.lakeev.exceptions.StationNameException;
import ru.lakeev.messages.ConsoleMsgTemplates;
import ru.lakeev.messages.ExceptionMsgTemplates;
import ru.lakeev.model.Line;
import ru.lakeev.model.Metro;
import ru.lakeev.model.Station;
import ru.lakeev.model.StationIndex;
import ru.lakeev.util.MetroDeserializer;
import ru.lakeev.util.MetroLogger;
import ru.lakeev.util.MetroSerializer;
import ru.lakeev.util.PageParser;

public class Main {

  private static final String JSON_FILE_PATH = "src/main/resources/mosMetro.json";

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    StationIndex stationIndex = MetroDeserializer.createStationIndex(getJsonFile());
    RouteCalculator calculator = new RouteCalculator(stationIndex);

    while (true) {

      MetroLogger.logMessage(ConsoleMsgTemplates.COMMANDS_LIST_MSG_TEMPLATE.getTemplate());
      String input = scanner.nextLine().trim();
      if (input.equals("EXIT")) {
        break;
      } else {
        if (input.equals("REPORT")) {

          MetroLogger.logReport(stationIndex.getReport());
        } else if (input.equals("ROUTE")) {
          try {
            Station from = takeStation(scanner, "Введите станцию отправления:", stationIndex);
            Station to = takeStation(scanner, "Введите станцию назначения:", stationIndex);
            List<Station> route = calculator.getShortestRoute(from, to);
            MetroLogger.logMessage("Маршрут:");
            printRoute(route);
            MetroLogger.logMessage(String
                .format(ConsoleMsgTemplates.ROUTE_DURATION_MSG_TEMPLATE.getTemplate(),
                    RouteCalculator.calculateDuration(route)));

          } catch (Exception e) {
            MetroLogger.logException(e);
            MetroLogger.logMessage(e.getMessage());
          }
        } else {
          MetroLogger.logMessage(ConsoleMsgTemplates.UNRECOGNIZED_COMMAND_MSG_TEMPLATE.getTemplate());
        }
      }
    }
  }


  private static void writeToFile(Metro metro, Gson gson) {

    try {
      FileWriter fileWriter = new FileWriter(JSON_FILE_PATH);
      fileWriter.write(gson.toJson(metro));
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      MetroLogger.logException(e);
      e.printStackTrace();
    }
  }

  private static String getJsonFile() {

    StringBuilder builder = new StringBuilder();
    try {
      if (!Paths.get(JSON_FILE_PATH).toFile().exists()) {
        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Metro.class, new MetroSerializer())
            .create();
        writeToFile(PageParser.parsePageToMetro(), gson);
      }
      List<String> lines = Files.readAllLines(Paths.get(JSON_FILE_PATH));
      lines.forEach(builder::append);
    } catch (Exception e) {
      MetroLogger.logException(e);
      e.printStackTrace();
    }
    return builder.toString();
  }

  private static Station takeStation(Scanner scanner, String message, StationIndex stationIndex)
      throws StationNameException {
    for (; ; ) {
      System.out.println(message);
      String line = scanner.nextLine().trim();
      if (line.matches(".*[1-9].*")) {
        throw new StationNameException(
            String.format(ExceptionMsgTemplates.STATION_NAME_EXCEPTION_TEMP.getTemplate(), line));
      }
      Station station = stationIndex.getStation(line);
      if (station != null) {
        return station;
      }
      MetroLogger.logMessage("Станция не найдена :(");
    }
  }

  private static void printRoute(List<Station> route) {
    Station previousStation = null;
    for (Station station : route) {
      if (previousStation != null) {
        Line prevLine = previousStation.getLine();
        Line nextLine = station.getLine();
        if (!prevLine.equals(nextLine)) {
          MetroLogger.logMessage(String
              .format(ConsoleMsgTemplates.CONNECTION_ON_THE_ROUTE_MSG_TEMPLATE.getTemplate(),
                  station.getName(),  nextLine.getName()));
        }
      }
      MetroLogger.logMessage("\t".concat(station.getName()));
      previousStation = station;
    }
  }
}
