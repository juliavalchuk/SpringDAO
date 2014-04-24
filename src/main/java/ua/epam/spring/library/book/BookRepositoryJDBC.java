package ua.epam.spring.library.book;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
        try {
            return jdbcTemplate.queryForObject("select * from book where id = ?", new BookMapper(), id);
        } catch (DataAccessException e) {
            return  null;
        }
    }

    @Override
    public Book getBookIfExist(Book book) {
        try {
            return jdbcTemplate.queryForObject("select * from book where title = ? and information = ? and rent = ? and mortgage = ?", new BookMapper(),
                    book.getBookTitle(), book.getBookInformation(), book.getBookRent(), book.getBookMortgage());
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Book> findAll() {
        try {
            return jdbcTemplate.query("select * from book", new BookMapper());
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean create(Book book) {
        return jdbcTemplate.update("insert into book (title, information, mortgage, rent) values (?, ?, ?, ?)", book.getBookTitle(), book.getBookInformation(),
                book.getBookMortgage(), book.getBookRent())  > 0;
    }

    @Override
    public boolean addGenreToBook(Integer bookId, Integer genreId) {
        return jdbcTemplate.update("insert into genrespool (book_id, genre_id) values (?, ?)", bookId, genreId)  > 0;
    }

    @Override
    public boolean addWriterToBook(Integer bookId, Integer writerId) {
        return jdbcTemplate.update("insert into writerspool (book_id, writer_id) values (?, ?)", bookId, writerId)  > 0;
    }

    @Override
    public List<Integer> getGenresOfBookByID(Integer id) {
        try {
            return jdbcTemplate.queryForList("select genre_id from genrespool where book_id = ?", Integer.class, id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Integer> getWritersOfBookById(Integer id) {
        try {
            return jdbcTemplate.queryForList("select writer_id from writerspool where book_id = ?", Integer.class,id);
        } catch (DataAccessException e) {
            return null;
        }
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
