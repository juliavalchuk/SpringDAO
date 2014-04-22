package ua.epam.spring.repository;

import ua.epam.spring.domain.Genre;

import java.util.List;

/**
 * Created by julia
 */
public interface GenreRepository {
    Genre find(Integer id);
    Genre findByName(String name);
    List<Genre> findAll();
    boolean create(Genre genre);
}
