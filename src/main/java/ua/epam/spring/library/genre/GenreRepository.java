package ua.epam.spring.library.genre;

import ua.epam.spring.library.genre.Genre;

import java.util.List;

/**
 * Created by julia
 */
public interface GenreRepository {
    Genre find(Integer id);
    List<Genre> find(List<Integer> ids);
    Genre findByName(String name);
    List<Genre> findAll();
    boolean create(Genre genre);
}
