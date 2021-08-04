package enumirations;

public enum  Querys {

  // Среднее количество продаж в месяц по каждому курсу:
  // за период - с первой до последней продажи, и за год - с первой продажи до конца года
  SQL_QUERY_AVG("SELECT PurchaseList.course_name, Grp.count AS purchase_count, "
      + "Grp.min_date AS first_purchase_date, Grp.max_date AS last_purchase_date, "
      + "Grp.count / (MONTH (Grp.max_date) - MONTH (Grp.min_date) + 1) AS period_avg_purchases_count, "
      + "Grp.count / (12 - MONTH (Grp.min_date) + 1) AS year_avg_purchases_count "
      + "FROM PurchaseList JOIN(SELECT course_name, "
      + "MIN(subscription_date) min_date, MAX(subscription_date) max_date, COUNT(*) count "
      + "FROM PurchaseList GROUP BY course_name) Grp "
      + "ON PurchaseList.course_name = Grp.course_name AND PurchaseList.subscription_date = Grp.max_date "
      + "ORDER BY course_name;"),
  // Среднее количество продаж каждого курса с группировкой по месяцам
  SQL_QUERY_MONTH("SELECT name AS course_name, "
      + "Grp.p_date AS purchase_month, Grp.p_count AS purchase_count FROM Courses "
      + "JOIN (SELECT course_name, MONTH(subscription_date) p_date, COUNT(*) p_count "
      + "FROM PurchaseList GROUP BY course_name, p_date) Grp "
      + "ON name = course_name "
      + "ORDER BY name , purchase_month;");

  private String query;

  Querys(String query) {

    this.query = query;
  }

  public String getQuery() {

    return query;
  }
}
