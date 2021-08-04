package executor;

import enumirations.TableTemplates;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logger.AppLogger;

public interface QueryExecutor {

  static void getAvgPurchases(Statement statement, String SQL_QUERY_AVG)
      throws SQLException {
    ResultSet resultSetAvg = statement.executeQuery(SQL_QUERY_AVG);

    AppLogger.logMessage(String.format(TableTemplates.AVG_TABLE_TEMP.getValue(),
        "НАЗВАНИЕ КУРСА", "ПРОДАНО КУРСОВ", "ДАТА  НАЧАЛА  ПРОДАЖ",
        "ДАТА ОКОНЧАНИЯ ПРОДАЖ", "СРЕДНЕЕ ЗА ПЕРИОД", "СРЕДНЕЕ ЗА ГОД"));

    while (resultSetAvg.next()) {
      AppLogger.logMessage(String.format(TableTemplates.AVG_TABLE_TEMP.getValue(),
          resultSetAvg.getString("course_name"),
          resultSetAvg.getString("purchase_count"),
          resultSetAvg.getString("first_purchase_date"),
          resultSetAvg.getString("last_purchase_date"),
          resultSetAvg.getString("period_avg_purchases_count"),
          resultSetAvg.getString("year_avg_purchases_count")));
    }
    resultSetAvg.close();
  }

  static void getPurchasesPerMonth(Statement statement, String SQL_QUERY_MONTH)
      throws SQLException {
    ResultSet resultSetMonth = statement.executeQuery(SQL_QUERY_MONTH);

    AppLogger.logMessage(String.format(TableTemplates.PURCHASES_PER_MONTH_TABLE_TEMP.getValue(),
        "НАЗВАНИЕ КУРСА", "МЕСЯЦ", "ПРОДАНО КУРСОВ"));

    while (resultSetMonth.next()) {
      AppLogger.logMessage(String.format(TableTemplates.PURCHASES_PER_MONTH_TABLE_TEMP.getValue(),
          resultSetMonth.getString("course_name"),
          resultSetMonth.getString("purchase_month"),
          resultSetMonth.getString("purchase_count")));
    }
    resultSetMonth.close();
  }
}
