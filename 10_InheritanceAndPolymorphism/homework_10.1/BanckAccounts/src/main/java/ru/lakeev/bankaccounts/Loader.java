package ru.lakeev.bankaccounts;

import ru.lakeev.bankaccounts.accounts.BankAccount;
import ru.lakeev.bankaccounts.accounts.CardAccount;

public class Loader {

  public static void main(String[] args) {

    BankAccount bankAccount = new BankAccount();
    CardAccount cardAccount = new CardAccount();
    System.out.println(bankAccount.getAccountNumber());
    System.out.println(cardAccount.getAccountNumber());

    bankAccount.put(5000.0);
    cardAccount.put(10000);

    cardAccount.take(10000);
    bankAccount.send(cardAccount, 200.0);
    bankAccount.put(-10);
    cardAccount.send(bankAccount, 500);
  }

}
