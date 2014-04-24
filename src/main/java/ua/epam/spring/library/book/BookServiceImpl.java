package ua.epam.spring.library.book;

import ua.epam.spring.library.genre.Genre;
import ua.epam.spring.library.writer.Writer;
import ua.epam.spring.library.genre.GenreRepository;
import ua.epam.spring.library.writer.WriterRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuliia_Valchuk on 4/23/2014.
 */
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    GenreRepository genreRepository;
    WriterRepository writerRepository;

    public BookServiceImpl(BookRepository bookRepository, GenreRepository genreRepository, WriterRepository writerRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.writerRepository = writerRepository;
    }

    @Override
    public Book find(Integer id) {
        Book book = bookRepository.find(id);
        book.setGenres(genreRepository.find(bookRepository.getGenresOfBookByID(id)));
        book.setWriters(writerRepository.find(bookRepository.getWritersOfBookById(id)));
        return book;
    }

    @Override
    public List<Book> find(List<Integer> ids) {
        List<Book> books = new ArrayList<Book>();
        for(int id: ids) {
            books.add(find(id));
        }
        return books;
    }

    @Override
    public boolean create(Book book) {
        return bookRepository.create(book);
    }

    @Override
    public boolean create(Book book, List<Genre> genres, List<Writer> writers) {
        boolean iscreaded = create(book);

        for(int i = 0; i < genres.size() && iscreaded; ++i){
            iscreaded &= addGenreToBook(book.getBookId(), genres.get(i).getGenreId());
        }
        for(int i = 0; i < writers.size() && iscreaded; ++i){
            iscreaded &= addWriterToBook(book.getBookId(), writers.get(i).getWriterId());
        }

        return iscreaded;
    }

    @Override
    public boolean addGenreToBook(Integer bookId, Integer genreId) {
        return bookRepository.addGenreToBook(bookId, genreId);
    }

    @Override
    public boolean addWriterToBook(Integer bookId, Integer writerId) {
        return bookRepository.addWriterToBook(bookId, writerId);
    }
}
