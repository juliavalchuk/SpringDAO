package ua.epam.spring.library.book;

import ua.epam.spring.library.book.Book;

import java.util.List;

/**
 * Created by julia
 */
public interface BookRepository {
    Book find(Integer id);
    Book getBookIfExist(Book book);
    List<Book> findAll();
    boolean create(Book book);
    boolean addGenreToBook(Integer bookId, Integer genreId);
    boolean addWriterToBook(Integer bookId, Integer writerId);
    List<Integer> getGenresOfBookByID(Integer id);
    List<Integer> getWritersOfBookById(Integer id);
}
