package ua.epam.spring.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.epam.spring.domain.Writer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by julia
 */
public final class WriterMapper implements RowMapper<Writer> {
    @Override
    public Writer mapRow(ResultSet resultSet, int i) throws SQLException {
        Writer writer = new Writer();
        writer.setWriterId(resultSet.getInt("id"));
        writer.setWriterName(resultSet.getString("name"));
        return writer;
    }
}
