
import log.AppLogger;
import storage.Database;

public class Main {

  private static final AppLogger APP_LOGGER = new AppLogger();

  public static void main(String[] args) {

    Database.init("hibernate.cfg.xml");
    APP_LOGGER.logResponse(Database.getCourses());
    APP_LOGGER.logResponse(Database.getStudents());
    APP_LOGGER.logResponse(Database.getTeachers());
    APP_LOGGER.logResponse(Database.getSubscriptions());
    APP_LOGGER.logResponse(Database.getPurchases());
    Database.createLinkedPurchaseList();
    APP_LOGGER.logResponse(Database.getLinkedPurchases());
    Database.close();
  }
}
