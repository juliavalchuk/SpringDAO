package ua.epam.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.epam.spring.domain.GenresPool;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by julia
 */
public class GenresPoolRepositoryJDBC implements IdIdBookRepository<GenresPool> {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public GenresPool find(Integer id) {
        return null;
    }

    @Override
    public List<GenresPool> findByBookId(Integer id) {
        return null;
    }

    @Override
    public List<GenresPool> findByAnotherId(Integer id) {
        return null;
    }

    @Override
    public List<GenresPool> findAll() {
        return null;
    }

    @Override
    public boolean create(GenresPool writer) {
        return false;
    }

    private static final class GenrePoolMapper implements RowMapper<GenresPool> {
        @Override
        public GenresPool mapRow(ResultSet resultSet, int i) throws SQLException {
            GenresPool genresPool = new GenresPool();
            genresPool.setGenreId(resultSet.getInt("id"));
            genresPool.setBookId(resultSet.getInt("book_id"));
            genresPool.setPoolId(resultSet.getInt("pool_id"));
            return genresPool;
        }
    }
}
