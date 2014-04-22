package ua.epam.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.epam.spring.domain.Writer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return jdbcTemplate.queryForObject("select * from writer where id = ?", new WriterMapper(), id);
    }

    @Override
    public Writer findByName(String name) {
        return jdbcTemplate.queryForObject("select * from writer where name = ?", new WriterMapper(), name);
    }

    @Override
    public List<Writer> findAll() {
        return jdbcTemplate.query("select * from writer", new WriterMapper());
    }

    @Override
    public boolean create(Writer writer) {
        return jdbcTemplate.update("insert into writer (id, name) values (?, ?)", writer.getWriterId(), writer.getWriterName())
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
