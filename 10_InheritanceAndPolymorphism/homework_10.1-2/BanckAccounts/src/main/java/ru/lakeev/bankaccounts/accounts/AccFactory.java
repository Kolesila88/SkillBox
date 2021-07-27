package ru.lakeev.bankaccounts.accounts;

public class AccFactory {

  public static BankAccount getAccount(String className) {

    switch (className) {

      case "BankAccount" :
        return BankAccount.getInstance();

      case "CardAccount" :
        return CardAccount.getInstance();

      case "DepositAccount" :
        return DepositAccount.getInstance();

      default:
        throw new IllegalArgumentException();
    }
  }
}
