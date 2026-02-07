package pl.microblog.dao;

import pl.microblog.model.Course;

import java.util.List;
import java.util.UUID;

public interface CourseDao {
    Course findById(UUID id);
    Course findByCode(String code);
    List<Course> findAll();
    void save(Course course);
    void delete(UUID id);
}
