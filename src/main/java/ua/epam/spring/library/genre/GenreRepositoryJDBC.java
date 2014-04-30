package ua.epam.spring.library.genre;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia
 */
public class GenreRepositoryJDBC implements GenreRepository {
    private JdbcTemplate jdbcTemplate;

    public GenreRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Genre find(Integer id) {
        try {
            return jdbcTemplate.queryForObject("select * from genre where id = ?", new GenreMapper(), id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Genre> find(List<Integer> ids) {
        try {
            List<Genre> genres = new ArrayList<Genre>();
            for(Integer id: ids) {
               genres.add(jdbcTemplate.queryForObject("select * from genre where id = ?", new GenreMapper(), id));
            }
            return genres;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Genre findByName(String name) {
        try {
            return jdbcTemplate.queryForObject("select * from genre where name = ?", new GenreMapper(), name);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Genre> findAll() {
        try {
            return jdbcTemplate.query("select * from genre", new GenreMapper());
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean create(Genre genre) {
        return jdbcTemplate.update("insert into genre (name) values (?)",genre.getGenreName())
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
