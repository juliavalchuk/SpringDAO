package ua.epam.spring.repository;

import ua.epam.spring.domain.Book;
import ua.epam.spring.domain.Genre;
import ua.epam.spring.domain.Writer;

import java.util.List;

/**
 * Created by julia
 */
public interface BookRepository {
    Book find(Integer id);
    //Book findByTitle(String title);
    List<Book> findAll();
    boolean create(Book genre);
    boolean addGenreToBook(Book book, Genre genre);
    boolean addWriterToBook(Book book, Writer writer);
}
