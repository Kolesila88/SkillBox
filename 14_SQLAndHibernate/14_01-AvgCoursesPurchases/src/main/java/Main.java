
import enumirations.Props;
import enumirations.Querys;
import executor.QueryExecutor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import logger.AppLogger;

public class Main {

  public static void main(String[] args) {

    try {
      Connection connection = DriverManager
          .getConnection(Props.DB_URL.getValue(), Props.USER_NAME.getValue(),
              Props.USER_PASSWORD.getValue());
      Statement statement = connection.createStatement();
      QueryExecutor.getAvgPurchases(statement, Querys.SQL_QUERY_AVG.getQuery());
      System.out.println();
      QueryExecutor.getPurchasesPerMonth(statement, Querys.SQL_QUERY_MONTH.getQuery());
      statement.close();
      connection.close();

    } catch (SQLException e) {
      AppLogger.logException(e);
      e.printStackTrace();
    }
  }
}
