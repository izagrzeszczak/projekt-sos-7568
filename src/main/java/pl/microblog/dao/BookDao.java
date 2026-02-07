package pl.microblog.dao;

import pl.microblog.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookDao {
    Book findById(UUID id);
    Book findByIsbn(String isbn);
    List<Book> findAll();
    void save(Book book);
    void delete(UUID id);
}
