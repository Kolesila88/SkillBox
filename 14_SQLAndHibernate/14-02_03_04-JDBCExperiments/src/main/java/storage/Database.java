package storage;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import log.AppLogger;
import model.Course;
import model.LinkedPurchase;
import model.Purchase;
import model.Student;
import model.Subscription;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Database {

  private static SessionFactory sessionFactory;
  private static Session session;

  public static void init(String config) {

    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure(config).build();
    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    sessionFactory = metadata.getSessionFactoryBuilder().build();
    session = sessionFactory.openSession();
  }

  public static List<Course> getCourses() {

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Course> query = builder.createQuery(Course.class);
    Root<Course> root = query.from(Course.class);
    query.select(root);

    return session.createQuery(query).getResultList();
  }

  public static List<Student> getStudents() {

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Student> query = builder.createQuery(Student.class);
    Root<Student> root = query.from(Student.class);
    query.select(root);

    return session.createQuery(query).getResultList();
  }

  public static List<Teacher> getTeachers() {

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Teacher> query = builder.createQuery(Teacher.class);
    Root<Teacher> root = query.from(Teacher.class);
    query.select(root);

    return session.createQuery(query).getResultList();
  }

  public static List<Subscription> getSubscriptions() {

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Subscription> query = builder.createQuery(Subscription.class);
    Root<Subscription> root = query.from(Subscription.class);
    query.select(root);

    return session.createQuery(query).getResultList();
  }

  public static List<Purchase> getPurchases() {

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Purchase> query = builder.createQuery(Purchase.class);
    Root<Purchase> root = query.from(Purchase.class);
    query.select(root);

    return session.createQuery(query).getResultList();
  }

  public static List<LinkedPurchase> getLinkedPurchases() {

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<LinkedPurchase> query = builder.createQuery(LinkedPurchase.class);
    Root<LinkedPurchase> root = query.from(LinkedPurchase.class);
    query.select(root);

    return session.createQuery(query).getResultList();
  }

  public static void createLinkedPurchaseList() {

    String hql = "select s.id, c.id From Purchase p Join Student s on p.pKey.studentName = s.name "
        + "Join Course c on p.pKey.courseName = c.name";
    List<Object[]> resultList = session.createQuery(hql).getResultList();

    for (Object[] result : resultList) {

      Transaction transaction = session.beginTransaction();
      LinkedPurchase linkedPurchase = new LinkedPurchase();
      LinkedPurchase.Key key = new LinkedPurchase.Key();
      key.setStudentId((int) result[0]);
      key.setCourseId((int) result[1]);
      linkedPurchase.setLpKey(key);

      session.saveOrUpdate(linkedPurchase);
      transaction.commit();
    }
    AppLogger.logMessage("Table 'LinkedPurchaseList' created");
    AppLogger.logMessage(resultList.size() + " entries added successfully");
  }

  public static void close() {

    session.close();
    sessionFactory.close();
  }
}
