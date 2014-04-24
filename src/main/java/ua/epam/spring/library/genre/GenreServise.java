package ua.epam.spring.library.genre;

import ua.epam.spring.library.genre.Genre;

import java.util.List;

/**
 * Created by Yuliia_Valchuk on 4/23/2014.
 */
public interface GenreServise {
    Genre find(Integer id);
    List<Genre> find(List<Integer> ids);
    Genre findByName(String name);
    boolean create(Genre genre);
}
