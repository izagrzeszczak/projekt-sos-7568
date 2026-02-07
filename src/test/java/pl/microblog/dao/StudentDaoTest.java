package pl.microblog.dao;

import pl.microblog.model.Student;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDaoTest {

    @Test
    void testFindAllStudents() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentDao studentDao = ctx.getBean(StudentDao.class);

        assertNotNull(studentDao.findAll());
        assertTrue(studentDao.findAll().size() >= 0);
    }
    void testFindStudentByIndex() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentDao studentDao = ctx.getBean(StudentDao.class);

        Student s = studentDao.findByIndexNo("7568");
        assertNotNull(s);
    }
}

