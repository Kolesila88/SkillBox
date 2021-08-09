package model;


import enums.CourseType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

//  Lombok
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

@Entity
@Table(name = "Courses")
public class Course implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private int duration;

  @NonNull
  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum")
  private CourseType type;

  private String description;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Teacher teacher;

  @Column(name = "students_count")
  private Integer studentsCount;

  private int price;

  @Column(name = "price_per_hour")
  private float pricePerHour;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "Subscriptions",
      joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
  private List<Student> students = new ArrayList<>();

  @OneToMany(mappedBy = "sbsKey.course", fetch = FetchType.LAZY)
  private List<Subscription> subscriptions;

  @OneToMany(mappedBy = "pKey.courseName", fetch = FetchType.LAZY)
  private List<Purchase> purchases;

  @Override
  public String toString() {
    return String.format("Course %d. %-45s\t%d students", getId(), getName(), getStudentsCount());
  }
}
