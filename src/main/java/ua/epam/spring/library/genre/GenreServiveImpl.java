package ua.epam.spring.library.genre;

import java.util.List;

/**
 * Created by Yuliia_Valchuk on 4/23/2014.
 */
public class GenreServiveImpl implements GenreServise {
    GenreRepository genreRepository;

    public GenreServiveImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre find(Integer id) {
        return genreRepository.find(id);
    }

    @Override
    public List<Genre> find(List<Integer> ids) {
        return genreRepository.find(ids);
    }

    @Override
    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public boolean create(Genre genre) {
        return genreRepository.create(genre);
    }
}
