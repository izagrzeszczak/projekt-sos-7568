package pl.microblog.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @Column(name = "book_id", nullable = false)
    private UUID bookId;

    @Column(name = "isbn", nullable = false, unique = true, length = 20)
    private String isbn;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "author", nullable = false, length = 255)
    private String author;

    @Column(name = "year", nullable = false)
    private Short year;

    public UUID getBookId() { return bookId; }
    public void setBookId(UUID bookId) { this.bookId = bookId; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Short getYear() { return year; }
    public void setYear(Short year) { this.year = year; }
}
