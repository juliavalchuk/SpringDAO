package ua.epam.spring.library.book;

import ua.epam.spring.library.book.Book;
import ua.epam.spring.library.genre.Genre;
import ua.epam.spring.library.writer.Writer;

import java.util.List;

/**
 * Created by Yuliia_Valchuk on 4/22/2014.
 */
public interface BookService {
    Book find(Integer id);
    List<Book> find(List<Integer> ids);
    boolean create(Book book);
    boolean create(Book book, List<Genre> genres, List<Writer> writers);
    boolean addGenreToBook(Integer bookId, Integer genreId);
    boolean addWriterToBook(Integer bookId, Integer writerId);
}
