package ru.lakeev.utils;

import ru.lakeev.bank.Account;
import ru.lakeev.bank.Bank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;
import ru.lakeev.utils.messages.LogMsg;

public class Log {

  private Log() {
  }

  private static final Logger LOGGER = LogManager.getLogger("Log");

  public static void debug(String msg) {
    LOGGER.debug(msg);
  }

  public static void info(String msg) {
    LOGGER.info(msg);
  }

  public static void error(Exception e) {
    LOGGER.error(e);
    LOGGER.error(e.getStackTrace());
  }

  public static void timerStart() {
    debug(String.format(LogMsg.TIMER_START_PATTERN.getMsg(), Thread.currentThread().getName()));
  }

  public static void timerFinish(long time) {
    debug(String
        .format(LogMsg.TIMER_FINISH_PATTERN.getMsg(), Thread.currentThread().getName(), time));
  }

  public static void created(Object obj) {
    info(String.format(LogMsg.OBJECT_CREATED_PATTERN.getMsg(), obj.toString()));
  }

  public static void accountBlocked(Account account) {
    info(String.format(LogMsg.ACCOUNT_BLOCK_PATTERN.getMsg(), account));
  }

  public static void accountUnBlocked(Account account) {
    info(String.format(LogMsg.ACCOUNT_UNBLOCK_PATTERN.getMsg(), account.toString()));
  }

  public static void callPolice(Account account) {
    info(String.format(LogMsg.CALL_POLICE_PATTERN.getMsg(), account.toString()));
  }

  public static void transfer(
      String fromAccountNum, String toAccountNum, long amount) {
    info(String.format(LogMsg.TRANSFER_MSG_PATTERN.getMsg(),
        fromAccountNum, toAccountNum, amount, Thread.currentThread().getName()));
  }

  public static void accountState(Bank bank, String accountNum) {
    LOGGER.info(String.format(LogMsg.ACCOUNT_BALANCE_MSG_PATTERN.getMsg(),
        accountNum, bank.getBalance(accountNum)));
  }

  public static void counters(AtomicInteger transfersCount, Bank bank) {
    debug(String.format(LogMsg.TRANSFERS_COUNT_MSG_PATTERN.getMsg(), transfersCount.intValue()));

    debug(String.format(LogMsg.FRAUD_CHECK_COUNT_MSG_PATTERN.getMsg(),
        bank.extFraudCheckCount.intValue()));

    debug(String.format(LogMsg.CALLS_TO_POLICE_COUNT_MSG_PATTERN.getMsg(),
        bank.callPoliceCount.intValue()));
  }

  public static void unBlockedAccountsCount(Bank bank) {
    info(String.format(LogMsg.UNBLOCK_ACCOUNTS_COUNT_MSG_PATTERN.getMsg(),
        bank.getUnblockedAccountsCount()));
  }
}
