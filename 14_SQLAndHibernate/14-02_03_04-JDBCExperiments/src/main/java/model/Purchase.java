package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


//Lombok
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"pKey", "price", "subscriptionDate"})

@Entity
@Table(name = "PurchaseList")
public class Purchase {

  @EmbeddedId
  private Key pKey;

  private int price;

  @Column(name = "subscription_date")
  Date subscriptionDate;

  // Lombok
  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(of = {"studentName", "courseName"})

  @Embeddable
  public static class Key implements Serializable {

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    @Override
    public String toString() {
      return String.format("%-45s\t%-35s", courseName, studentName);
    }
  }

  @Override
  public String toString() {
    return String.format("Purchase\t%s\t%8s\t%s", getPKey(), getPrice(), getSubscriptionDate());
  }
}

