package pl.microblog.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @Column(name = "student_id", nullable = false)
    private UUID studentId;

    @Column(name = "account_id", nullable = false, unique = true)
    private UUID accountId;

    @Column(name = "index_no", nullable = false, unique = true, length = 20)
    private String indexNo;

    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "program", nullable = false, length = 120)
    private String program;

    @Column(name = "semester", nullable = false)
    private Integer semester;

    public UUID getStudentId() { return studentId; }
    public void setStudentId(UUID studentId) { this.studentId = studentId; }

    public UUID getAccountId() { return accountId; }
    public void setAccountId(UUID accountId) { this.accountId = accountId; }

    public String getIndexNo() { return indexNo; }
    public void setIndexNo(String indexNo) { this.indexNo = indexNo; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public Integer getSemester() { return semester; }
    public void setSemester(Integer semester) { this.semester = semester; }
}

