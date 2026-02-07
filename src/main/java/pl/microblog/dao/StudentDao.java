package pl.microblog.dao;

import pl.microblog.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    Student findById(UUID id);

    Student findByIndexNo(String indexNo);

    List<Student> findAll();

    void save(Student student);

    void delete(UUID id);
}
