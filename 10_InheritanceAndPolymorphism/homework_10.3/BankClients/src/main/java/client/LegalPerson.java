package client;

import client.parent.Client;
import enumirations.Conditions;
import enumirations.Msg;
import enumirations.OperationResults;
import enumirations.OperationType;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class LegalPerson extends Client {

  @Override
  public void put(double amountToPut) {

    if (amountToPut > 0) {

      setAmount(
          BigDecimal.valueOf(getAmount()).add(BigDecimal.valueOf(amountToPut)).doubleValue());
      System.out.printf(
          Msg.OPERATION_DETAILS_MSG.getMessage(), OperationResults.APPROVED.getTxt(),
          OperationType.PUT.getType(), amountToPut);
    } else {

      System.err.printf(
          Msg.OPERATION_DETAILS_MSG.getMessage(), OperationResults.DECLINED.getTxt(),
          OperationType.PUT.getType(), amountToPut);
    }
  }

  @Override
  public void take(double amountToTake) {

    BigDecimal commission = BigDecimal.valueOf(amountToTake)
        .divide(BigDecimal.valueOf(100), 2, RoundingMode.DOWN);

    if (BigDecimal.valueOf(getAmount()).subtract(BigDecimal.valueOf(amountToTake))
        .compareTo(commission) > 0) {

      setAmount(
          BigDecimal.valueOf(getAmount())
              .subtract(BigDecimal.valueOf(amountToTake).add(commission))
              .doubleValue());
      System.out.printf(
          Msg.OPERATION_DETAILS_MSG.getMessage(), OperationResults.APPROVED.getTxt(),
          OperationType.TAKE.getType(), amountToTake);
    } else {

      System.err.printf(
          Msg.OPERATION_DETAILS_MSG.getMessage(), OperationResults.DECLINED.getTxt(),
          OperationType.TAKE.getType(), amountToTake);
    }
  }

  @Override
  public void printClientCondition() {

    printTariffCondition(getAmount(), this.getClass().getSimpleName(),
        Conditions.NO_COMMISSION.getConditions(), Conditions.LP_TAKE.getConditions());
  }
}
