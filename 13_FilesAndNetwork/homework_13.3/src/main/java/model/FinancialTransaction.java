package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FinancialTransaction {

  private AccType accType;
  private String accNumber;
  private Currency currency;
  private LocalDate transactionDate;
  private String reference;
  private String transDescription;
  private TransactionType type;
  private BigDecimal amount;
}
