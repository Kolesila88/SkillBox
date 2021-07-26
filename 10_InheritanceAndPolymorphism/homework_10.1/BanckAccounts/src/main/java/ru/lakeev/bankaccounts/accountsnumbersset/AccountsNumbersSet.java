package ru.lakeev.bankaccounts.accountsnumbersset;

import java.util.HashSet;
import java.util.Set;
import ru.lakeev.bankaccounts.enumirations.Pttrn;

public class AccountsNumbersSet {


  private static Set<String> accountNumbers;

  public static Set<String> getAccountNumbers() {

    if (accountNumbers == null) {
      accountNumbers = new HashSet<>();
    }
    return accountNumbers;
  }

  public static String generateAndGetAccNum() {

    while (true) {
      String accNumPref = "4081781057000";
      StringBuilder accNumSuf = new StringBuilder()
          .append((getAccountNumbers().size() + 1));

      if (accNumSuf.toString().length() < 7) {
        while (true) {
          if (accNumSuf.toString().length() == 7) {
            break;
          }
          accNumSuf.insert(0, "0");
        }
      }
      String accNum = accNumPref.concat(accNumSuf.toString());
      if (accNum.matches(Pttrn.ACC_NUM_PATTERN.getPattern())) {
        getAccountNumbers().add(accNum);
        return accNum;
      }
    }
  }
}
