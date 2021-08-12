package ru.lakeev.utils.messages;

public enum LogMsg {

  OBJECT_CREATED_PATTERN("Created:        \t%s"),
  ACCOUNT_BLOCK_PATTERN("Blocked:        \t%s"),
  ACCOUNT_UNBLOCK_PATTERN("Unblocked:      \t%s"),
  CALL_POLICE_PATTERN("Call police !!! \t%s"),
  TRANSFER_MSG_PATTERN("TRANSFER        \t%s -> %s  %10d rub\t%s"),
  ACCOUNT_BALANCE_MSG_PATTERN("Account %s\t%s rub"),
  TRANSFERS_COUNT_MSG_PATTERN("Transfers count:      \t%d"),
  FRAUD_CHECK_COUNT_MSG_PATTERN("Ext.fraud check count:\t%d"),
  CALLS_TO_POLICE_COUNT_MSG_PATTERN("Call Police count:    \t%d"),
  UNBLOCK_ACCOUNTS_COUNT_MSG_PATTERN("Unblocked accounts:\t%d"),
  TIMER_START_PATTERN("Start %s"),
  TIMER_FINISH_PATTERN("Finish %s - %s"),
  ACCOUNT_LIST_PATTERN("%nACCOUNTS LIST%n%s%n-----"),
  BALANCE_PATTERN("-----%nBank balance:\t%d rub"),
  BALANCE_DIFFERENCE_PATTERN("Difference with start bank balance: %s"),
  FRAUD("FRAUD TRANSFER!!!"),
  CHECK_START("Ext. check start:  \tAccount %s"),
  CHECK_FINISH("Ext.verify finish: \tAccount %s"),
  BLOCKED_ACCOUNTS("TRANSFER BETWEEN BLOCKED ACCOUNTS DENIED !!!"),
  SAME_ACCOUNTS("TRANSFER BETWEEN THE SAME ACCOUNT IS NOT ALLOWED !!!"),
  NOT_ENOUGH_MONEY("NOT ENOUGH MONEY IN THE ACCOUNT !!!"),
  ZERO_AMOUNT_TRANSFER("ZERO-AMOUNT TRANSFERS ARE NOT ALLOWED !!!");

  private final String msg;

  LogMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}
