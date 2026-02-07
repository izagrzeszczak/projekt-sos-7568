package pl.microblog.dao.impl;

import pl.microblog.dao.BookDao;
import pl.microblog.model.Book;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book findById(UUID id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public Book findByIsbn(String isbn) {
        TypedQuery<Book> q = entityManager.createQuery(
                "SELECT b FROM Book b WHERE b.isbn = :isbn", Book.class);
        q.setParameter("isbn", isbn);
        List<Book> res = q.getResultList();
        return res.isEmpty() ? null : res.get(0);
    }

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
    }

    @Override
    public void save(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void delete(UUID id) {
        Book b = findById(id);
        if (b != null) entityManager.remove(b);
    }
}
