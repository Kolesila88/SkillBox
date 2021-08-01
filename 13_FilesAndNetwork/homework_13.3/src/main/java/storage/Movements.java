package storage;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.FinancialTransaction;
import model.TransactionType;
import util.Parser;

public class Movements {

  private List<FinancialTransaction> transactionList;

  public Movements(String pathMovementsCsv) {

    this.transactionList = Parser.parse(pathMovementsCsv);
  }

  public double getExpenseSum() {
    return transactionList.stream().filter(t -> t.getType().equals(TransactionType.EXPENSE))
        .map(FinancialTransaction::getAmount).mapToDouble(BigDecimal::doubleValue).sum();
  }

  public double getIncomeSum() {
    return transactionList.stream().filter(t -> t.getType().equals(TransactionType.INCOME))
        .map(FinancialTransaction::getAmount).mapToDouble(BigDecimal::doubleValue).sum();
  }

  public String getBilling() {

    Set<String> tradeOrganizations = new HashSet<>();
    transactionList.forEach(t -> tradeOrganizations.add(
        t.getTransDescription().split(" ", 2)[1].trim().split("\\.", 2)[0]
            .substring(0, t.getTransDescription().split(" ", 2)[1].trim()
                .split("\\.", 2)[0].lastIndexOf(" ")).trim()));

    String billing = "";
    for (String tO : tradeOrganizations) {
      billing = billing.concat(System.lineSeparator()
          .concat("\t\t\t\t\t\t\t\t\t\t\t\t\t\t")
          .concat(tO)
          .concat(": ")
          .concat(String.valueOf(transactionList.stream()
              .filter(t -> t.getType().equals(TransactionType.EXPENSE))
              .filter(t -> t.getTransDescription().split(" ", 2)[1].trim()
                  .split("\\.", 2)[0].substring(0, t.getTransDescription()
                  .split(" ", 2)[1].trim().split("\\.", 2)[0]
                  .lastIndexOf(" ")).trim().equals(tO))
              .map(FinancialTransaction::getAmount)
              .mapToDouble(BigDecimal::doubleValue).sum())));
    }
    return billing;
  }
}

