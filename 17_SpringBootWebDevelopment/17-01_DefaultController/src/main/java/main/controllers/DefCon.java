package main.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DefCon {

  @RequestMapping("/")
  public String index() {

    return String.format("Дата: %s Время: %s",
        DateTimeFormatter.ofPattern("dd.MM.yyyy - E").format(LocalDate.now()),
        DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()));
  }
}
