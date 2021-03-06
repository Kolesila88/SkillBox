package ru.lakeev;

import ru.lakeev.bank.Bank;
import ru.lakeev.utils.Log;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import ru.lakeev.utils.messages.LogMsg;

public class Main {

  private static final Random RANDOM = new Random();

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    Log.timerStart();

    AtomicInteger transfersCount = new AtomicInteger();

    Bank bank = new Bank("New Bank");

    int accountsCount = 10;
    createRandomAccounts(bank, accountsCount);

    BigInteger startBankBalance = bank.getBankBalance();

    // To make a transfer, at least two accounts must be not blocked
    while (bank.getUnblockedAccountsCount() >= 2) {
      randomTransfer(bank);
      transfersCount.incrementAndGet();
      Log.counters(transfersCount, bank);
    }

    Log.info(String.format(LogMsg.BALANCE_DIFFERENCE_PATTERN.getMsg(),
        bank.getBankBalance().subtract(startBankBalance)));
    Log.counters(transfersCount, bank);
    Log.timerFinish(System.currentTimeMillis() - startTime);
  }

  private static void createRandomAccounts(Bank bank, int count) {
    int maxBalance = 2_000_000;
    for (int i = 0; i < count; i++) {
      long money = RANDOM.nextInt(maxBalance);
      bank.createAccount(money);
    }
  }

  private static void randomTransfer(Bank bank) {
    String fromAccountNum = bank.getRandomAccountNum();
    String toAccountNum = bank.getRandomAccountNum();
    long amount = (long) (bank.getBalance(fromAccountNum) * RANDOM.nextDouble());

    bank.transfer(fromAccountNum, toAccountNum, amount);
  }
}