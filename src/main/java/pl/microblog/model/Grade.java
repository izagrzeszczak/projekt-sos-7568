package pl.microblog.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "GRADE")
public class Grade {

    @Id
    @Column(name = "grade_id", nullable = false)
    private UUID gradeId;

    @Column(name = "enrollment_id", nullable = false, unique = true)
    private UUID enrollmentId;

    @Column(name = "grade_value", precision = 3, scale = 1)
    private BigDecimal gradeValue;

    @Column(name = "passed", nullable = false)
    private Boolean passed;

    @Column(name = "graded_at")
    private LocalDateTime gradedAt;

    @Column(name = "comment", length = 255)
    private String comment;

    public UUID getGradeId() { return gradeId; }
    public void setGradeId(UUID gradeId) { this.gradeId = gradeId; }

    public UUID getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(UUID enrollmentId) { this.enrollmentId = enrollmentId; }

    public BigDecimal getGradeValue() { return gradeValue; }
    public void setGradeValue(BigDecimal gradeValue) { this.gradeValue = gradeValue; }

    public Boolean getPassed() { return passed; }
    public void setPassed(Boolean passed) { this.passed = passed; }

    public LocalDateTime getGradedAt() { return gradedAt; }
    public void setGradedAt(LocalDateTime gradedAt) { this.gradedAt = gradedAt; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
