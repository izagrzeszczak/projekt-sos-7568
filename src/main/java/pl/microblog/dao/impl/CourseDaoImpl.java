package pl.microblog.dao.impl;

import pl.microblog.dao.CourseDao;
import pl.microblog.model.Course;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Course findById(UUID id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public Course findByCode(String code) {
        TypedQuery<Course> q = entityManager.createQuery(
                "SELECT c FROM Course c WHERE c.code = :code", Course.class);
        q.setParameter("code", code);
        List<Course> res = q.getResultList();
        return res.isEmpty() ? null : res.get(0);
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class)
                .getResultList();
    }

    @Override
    public void save(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void delete(UUID id) {
        Course c = findById(id);
        if (c != null) entityManager.remove(c);
    }
}

