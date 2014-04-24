package ua.epam.spring.library.writer;

import ua.epam.spring.library.writer.Writer;

import java.util.List;

/**
 * Created by julia
 */
public interface WriterRepository {
    Writer find(Integer id);
    List<Writer> find(List<Integer> ids);
    Writer findByName(String name);
    List<Writer> findAll();
    boolean create(Writer writer);
}
