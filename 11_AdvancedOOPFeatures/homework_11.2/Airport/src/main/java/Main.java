import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    findPlanesLeavingInTheNextTwoHours(Airport.getInstance()).forEach(System.out::println);
  }

  public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

    return airport.getTerminals().stream()
        .map(Terminal::getFlights)
        .flatMap(Collection::stream)
        .filter(f -> f.getType().name().equals("DEPARTURE"))
        .filter(f -> LocalDateTime.ofEpochSecond(f.getDate().getTime() / 1000,
            0, ZoneOffset.ofHours(3)).isBefore(LocalDateTime.now().plusHours(2)))
        .filter(f -> LocalDateTime.ofEpochSecond(f.getDate().getTime() / 1000,
            0, ZoneOffset.ofHours(3)).isAfter(LocalDateTime.now()))
        .collect(Collectors.toList());
  }
}