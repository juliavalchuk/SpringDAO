package ua.epam.spring.repository;

import ua.epam.spring.domain.Writer;

import java.util.List;

/**
 * Created by julia
 */
public interface WriterRepository {
    Writer find(Integer id);
    Writer findByName(String name);
    List<Writer> findAll();
    boolean create(Writer writer);
}
