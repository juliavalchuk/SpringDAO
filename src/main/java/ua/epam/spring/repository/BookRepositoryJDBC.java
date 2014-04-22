package ua.epam.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.epam.spring.domain.Book;
import ua.epam.spring.domain.Genre;
import ua.epam.spring.domain.Writer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by julia
 */
public class BookRepositoryJDBC implements BookRepository{
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Book find(Integer id) {
        return jdbcTemplate.queryForObject("select * from book where id = ?", new BookMapper(), id);
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("select * from book", new BookMapper());
    }

    @Override
    public boolean create(Book genre) {
        return false;
    }

    @Override
    public boolean addGenreToBook(Book book, Genre genre) {
        return false;
    }

    @Override
    public boolean addWriterToBook(Book book, Writer writer) {
        return false;
    }

    private static final class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            Book book = new Book();
            book.setBookId(resultSet.getInt("id"));
            book.setBookTitle(resultSet.getString("title"));
            book.setBookInformation(resultSet.getString("information"));
            book.setBookMortgage(resultSet.getDouble("mortgage"));
            book.setBookRent(resultSet.getDouble("rent"));
            /// set genres, set writers
            return book;
        }
    }
}
