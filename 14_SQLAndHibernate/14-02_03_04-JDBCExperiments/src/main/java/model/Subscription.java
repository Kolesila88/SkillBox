package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"sbsKey", "subscriptionDate"})
@Entity
@Table(name = "Subscriptions")
public class Subscription implements Serializable {

  @EmbeddedId
  private Key sbsKey;

  @Column(name = "subscription_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date subscriptionDate;

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(of = {"student", "course"})
  @Embeddable
  public static class Key implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    protected Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    protected Course course;

    @Override
    public String toString() {
      return String.format("%-45s\t%-35s", getCourse().getName(), getStudent().getName());
    }
  }

  @Override
  public String toString() {
    return String.format("Subscription\t%s\t%s", getSbsKey(), getSubscriptionDate());
  }
}