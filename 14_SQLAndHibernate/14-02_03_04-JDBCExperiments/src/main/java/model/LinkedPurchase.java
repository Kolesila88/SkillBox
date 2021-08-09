package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// Lombok
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"lpKey"})

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchase implements Serializable {

  @EmbeddedId
  private Key lpKey;

  public LinkedPurchase(int courseId, int studentId) {
    this.lpKey = new Key(courseId, studentId);
  }

  @Override
  public String toString() {
    return lpKey.toString();
  }

  // Lombok
  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(of = {"courseId", "studentId"})

  @Embeddable
  public static class Key implements Serializable {

    @Column(name = "course_id")
    int courseId;

    @Column(name = "student_id")
    int studentId;

    public Key(int courseId, int studentId) {
      this.courseId = courseId;
      this.studentId = studentId;
    }

    @Override
    public String toString() {
      return String.format("Course Id = %-2d\t\tStudent Id = %-2d", getCourseId(), getStudentId());
    }
  }
}
