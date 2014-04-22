package ua.epam.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.epam.spring.domain.Genre;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by julia
 */
public class GenreRepositoryJDBC implements GenreRepository {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Genre find(Integer id) {
        return jdbcTemplate.queryForObject("select * from genre where id = ?", new GenreMapper(), id);
    }

    @Override
    public Genre findByName(String name) {
        return jdbcTemplate.queryForObject("select * from genre where name = ?", new GenreMapper(), name);
    }

    @Override
    public List<Genre> findAll() {
        return jdbcTemplate.query("select * from genre", new GenreMapper());
    }

    @Override
    public boolean create(Genre genre) {
        return jdbcTemplate.update("insert into genre (id, name) values (?, ?)", genre.getGenreId(), genre.getGenreName())
                > 0;

    }

    private static final class GenreMapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            Genre genre = new Genre();
            genre.setGenreId(resultSet.getInt("id"));
            genre.setGenreName(resultSet.getString("name"));
            return genre;
        }
    }
}
