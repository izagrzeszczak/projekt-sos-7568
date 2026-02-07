package pl.microblog.dao.impl;

import pl.microblog.dao.StudentDao;
import pl.microblog.model.Student;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student findById(UUID id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student findByIndexNo(String indexNo) {
        TypedQuery<Student> q = entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.indexNo = :idx", Student.class);
        q.setParameter("idx", indexNo);

        List<Student> res = q.getResultList();
        return res.isEmpty() ? null : res.get(0);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
    }

    @Override
    public void save(Student student) {
        // merge działa zarówno dla nowego, jak i istniejącego obiektu
        entityManager.merge(student);
    }

    @Override
    public void delete(UUID id) {
        Student s = findById(id);
        if (s != null) {
            entityManager.remove(s);
        }
    }
}
