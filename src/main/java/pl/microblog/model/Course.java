package pl.microblog.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @Column(name = "course_id", nullable = false)
    private UUID courseId;

    @Column(name = "code", nullable = false, unique = true, length = 20)
    private String code;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "ects", nullable = false, precision = 3, scale = 1)
    private BigDecimal ects;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Lob
    @Column(name = "description")
    private String description;

    public UUID getCourseId() { return courseId; }
    public void setCourseId(UUID courseId) { this.courseId = courseId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getEcts() { return ects; }
    public void setEcts(BigDecimal ects) { this.ects = ects; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
