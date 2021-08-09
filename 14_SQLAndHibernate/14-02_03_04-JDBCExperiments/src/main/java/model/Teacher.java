package model;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

// Lombok
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})

@Entity
@Table(name = "Teachers")
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NonNull
  private String name;

  private int salary;

  private int age;

  @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
  private List<Course> courses;

  @Override
  public String toString() {
    return String.format("Teacher %-2d. %-100s", getId(), getName());
  }
}

