package ua.epam.spring.library.writer;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.epam.spring.library.writer.Writer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julia
 */
public class WriterRepositoryJDBC implements WriterRepository{
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Writer find(Integer id) {
        try {
            return jdbcTemplate.queryForObject("select * from writer where id = ?", new WriterMapper(), id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Writer> find(List<Integer> ids) {
        try {
            List<Writer> writers = new ArrayList<Writer>();
            for(Integer id: ids) {
                writers.add(jdbcTemplate.queryForObject("select * from genre where id = ?", new WriterMapper(), id));
            }
            return writers;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Writer findByName(String name) {
        try {
            return jdbcTemplate.queryForObject("select * from writer where name = ?", new WriterMapper(), name);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Writer> findAll() {
        try {
            return jdbcTemplate.query("select * from writer", new WriterMapper());
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean create(Writer writer) {
        return jdbcTemplate.update("insert into writer (name) values (?)", writer.getWriterName())
                > 0;

    }

    private static final class WriterMapper implements RowMapper<Writer> {
        @Override
        public Writer mapRow(ResultSet resultSet, int i) throws SQLException {
            Writer writer = new Writer();
            writer.setWriterId(resultSet.getInt("id"));
            writer.setWriterName(resultSet.getString("name"));
            return writer;
        }
    }
}
