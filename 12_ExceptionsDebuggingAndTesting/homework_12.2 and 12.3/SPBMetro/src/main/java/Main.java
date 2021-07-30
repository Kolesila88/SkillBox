
import core.Line;
import core.Station;
import exception.CommandException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

  private static Logger logger;
  private static final Marker INPUT_OK = MarkerManager.getMarker("INPUT_OK");
  private static final Marker INPUT_ERROR = MarkerManager.getMarker("INPUT_ERROR");
  private static final Marker EXCEPTION = MarkerManager.getMarker("EXCEPTION");

  private static final String DATA_FILE = "src/main/resources/map.json";
  private static Scanner scanner;

  private static StationIndex stationIndex;

  public static void main(String[] args) {

    logger = LogManager.getRootLogger();
    RouteCalculator calculator = getRouteCalculator();
    System.out.println("Программа расчёта маршрутов метрополитена Санкт-Петербурга\n");
    scanner = new Scanner(System.in);
    for (; ; ) {
      try {
        Station from = takeStation("Введите станцию отправления:");
        Station to = takeStation("Введите станцию назначения:");
        List<Station> route = calculator.getShortestRoute(from, to);
        System.out.println("Маршрут:");
        printRoute(route);
        System.out.println("Длительность: " +
            RouteCalculator.calculateDuration(route) + " минут");
      } catch (Exception e) {
        logger.error(EXCEPTION, e.getMessage());
        e.printStackTrace();
      }
    }
  }

  private static RouteCalculator getRouteCalculator() {
    createStationIndex();
    return new RouteCalculator(stationIndex);
  }

  private static void printRoute(List<Station> route) {
    Station previousStation = null;
    for (Station station : route) {
      if (previousStation != null) {
        Line prevLine = previousStation.getLine();
        Line nextLine = station.getLine();
        if (!prevLine.equals(nextLine)) {
          System.out.println("\tПереход на станцию " +
              station.getName() + " (" + nextLine.getName() + " линия)");
        }
      }
      System.out.println("\t" + station.getName());
      previousStation = station;
    }
  }

  private static Station takeStation(String message) throws CommandException {
    for (; ; ) {
      System.out.println(message);
      String line = scanner.nextLine().trim();
      if (line.matches(".*[1-9].*")) {
        throw new CommandException("Название станции не может содержать цифр: " + line);
      }

      Station station = stationIndex.getStation(line);
      if (station != null) {
        logger.info(INPUT_OK, "Введено название станции: " + line);
        return station;
      }
      logger.info(INPUT_ERROR, "Станция назначения: " + line);
      System.out.println("Станция не найдена :(");
    }
  }

  private static void createStationIndex() {
    stationIndex = new StationIndex();
    try {
      JSONParser parser = new JSONParser();
      JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

      JSONArray linesArray = (JSONArray) jsonData.get("lines");
      parseLines(linesArray);

      JSONObject stationsObject = (JSONObject) jsonData.get("stations");
      parseStations(stationsObject);

      JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
      parseConnections(connectionsArray);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static void parseConnections(JSONArray connectionsArray) {
    connectionsArray.forEach(connectionObject ->
    {
      JSONArray connection = (JSONArray) connectionObject;
      List<Station> connectionStations = new ArrayList<>();
      connection.forEach(item ->
      {
        JSONObject itemObject = (JSONObject) item;
        int lineNumber = ((Long) itemObject.get("line")).intValue();
        String stationName = (String) itemObject.get("station");

        Station station = stationIndex.getStation(stationName, lineNumber);
        if (station == null) {
          throw new IllegalArgumentException("core.Station " +
              stationName + " on line " + lineNumber + " not found");
        }
        connectionStations.add(station);
      });
      stationIndex.addConnection(connectionStations);
    });
  }

  private static void parseStations(JSONObject stationsObject) {
    stationsObject.keySet().forEach(lineNumberObject ->
    {
      int lineNumber = Integer.parseInt((String) lineNumberObject);
      Line line = stationIndex.getLine(lineNumber);
      JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
      stationsArray.forEach(stationObject ->
      {
        Station station = new Station((String) stationObject, line);
        stationIndex.addStation(station);
        line.addStation(station);
      });
    });
  }

  private static void parseLines(JSONArray linesArray) {
    linesArray.forEach(lineObject -> {
      JSONObject lineJsonObject = (JSONObject) lineObject;
      Line line = new Line(
          ((Long) lineJsonObject.get("number")).intValue(),
          (String) lineJsonObject.get("name")
      );
      stationIndex.addLine(line);
    });
  }

  private static String getJsonFile() {
    StringBuilder builder = new StringBuilder();
    try {
      List<String> lines = Files.readAllLines(Paths.get(DATA_FILE));
      lines.forEach(builder::append);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return builder.toString();
  }
}