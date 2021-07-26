package ru.lakeev.bankaccounts;

import ru.lakeev.bankaccounts.accounts.AccFactory;
import ru.lakeev.bankaccounts.accounts.BankAccount;
import ru.lakeev.bankaccounts.accounts.CardAccount;
import ru.lakeev.bankaccounts.accounts.DepositAccount;

public class Loader {

  public static void main(String[] args) {

    BankAccount bankAccount = AccFactory.getAccount(BankAccount.class.getSimpleName());
    CardAccount cardAccount = (CardAccount) AccFactory
        .getAccount(CardAccount.class.getSimpleName());
    DepositAccount depositAccount = (DepositAccount) AccFactory
        .getAccount(DepositAccount.class.getSimpleName());


    bankAccount.put(5000.0);
    cardAccount.put(10000);

    cardAccount.take(10000);
    bankAccount.send(cardAccount, 200.0);
    bankAccount.put(-10);
    cardAccount.send(bankAccount, 500);
  }

}
