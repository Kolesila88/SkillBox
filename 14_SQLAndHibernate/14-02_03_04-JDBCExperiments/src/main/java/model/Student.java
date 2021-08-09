package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name", "registrationDate"})

@Entity
@Table(name = "Students")
public class Student implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NonNull
  private String name;

  private int age;

  @NonNull
  @Column(name = "registration_date")
  @Temporal(TemporalType.TIMESTAMP)
  Date registrationDate;

  @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
  private List<Course> courses = new ArrayList<>();

  @OneToMany(mappedBy = "sbsKey.student", fetch = FetchType.LAZY)
  private List<Subscription> subscriptions;

  @OneToMany(mappedBy = "pKey.studentName", fetch = FetchType.LAZY)
  private List<Purchase> purchases;

  @Override
  public String toString() {
    return String.format("Student %-2d. %-100s", getId(), getName());
  }
}
