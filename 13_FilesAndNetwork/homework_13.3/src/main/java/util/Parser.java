package util;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import model.AccType;
import model.Currency;
import model.FinancialTransaction;
import model.TransactionType;
import util.templates.ExceptionMsgTemplate;

public class Parser {

  public static List<FinancialTransaction> parse(String pathToFile) {

    try {
      CSVReader reader = new CSVReader(new FileReader(pathToFile),
          ',', '"', 1);
      List<String[]> allRows = reader.readAll();
      return allRows.stream()
          .map(r -> {
            HashMap<String, Object> trMap = new HashMap<>();

            if (r[0].matches("Текущий счёт")) {
              trMap.put("accType", AccType.CURRENT_ACCOUNT);
            }

            trMap.put("accNumber", r[1]);
            trMap.put("currency", Currency.valueOf(r[2]));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
            trMap.put("transactionDate", LocalDate.parse(r[3], formatter));
            trMap.put("reference", r[4]);
            trMap.put("transDescription", r[5]);

            if (r[6].matches("[\"]?[\\d]+[,]?[\\d]{0,2}[\"]?") && r[7].matches("0")) {
              trMap.put("type", TransactionType.INCOME);
              trMap.put("amount", new BigDecimal(r[6].replaceAll(",", ".")));
            } else if (r[7].matches("[\"]?[\\d]+[,]?[\\d]{0,2}[\"]?") && r[6].matches("0")) {
              trMap.put("type", TransactionType.EXPENSE);
              trMap.put("amount", new BigDecimal(r[7].replaceAll(",", ".")));

            } else {
              try {
                throw new IOException(String
                    .format(ExceptionMsgTemplate.INCORRECTLY_PROCESSED_OPERATION.getTemplate(),
                        r[6], r[7]));
              } catch (IOException e) {
                MovementsLogger.logException(e);
              }
            }
            return trMap;
          })
          .map(trMap -> FinancialTransaction.builder()
              .accType((AccType) trMap.get("accType"))
              .accNumber((String) trMap.get("accNumber"))
              .currency((Currency) trMap.get("currency"))
              .transactionDate((LocalDate) trMap.get("transactionDate"))
              .reference((String) trMap.get("reference"))
              .transDescription((String) trMap.get("transDescription"))
              .type((TransactionType) trMap.get("type"))
              .amount((BigDecimal) trMap.get("amount"))
              .build()
          ).collect(Collectors.toList());
    } catch (IOException e) {

      MovementsLogger.logException(e);
      return null;
    }
  }

}
