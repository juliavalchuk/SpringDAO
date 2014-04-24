package ua.epam.spring.library.genre;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.epam.spring.library.RepositoryTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yuliia_Valchuk on 4/23/2014.
 */

@ContextConfiguration(locations = {"/connectionContextTest.xml", "/genreContex.xml"})
public class GenreRepositoryJDBCTest extends RepositoryTest{
    @Autowired
    private GenreRepository genreRepository;

    @Before
    public void setUp() throws Exception {
        jdbcTemplate.execute("delete from genre");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreateOneRecord(){
        Genre genre = new Genre();
        genre.setGenreName("horror");
        genreRepository.create(genre);

        int size = jdbcTemplate.queryForObject("select count(*) from genre", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNullGenre(){
        Genre genre = null;
        genreRepository.create(genre);

        int size = jdbcTemplate.queryForObject("select count(*) from genre", Integer.class);
       // Assert.assertEquals(1, size);
    }

    @Test
    public void testFindAllEmptyTable(){
        int size = genreRepository.findAll().size();
        Assert.assertEquals(0, size);
    }

    @Test
    public void testFindAllNotEmptyTable(){
        genreRepository.create(new Genre("action"));
        genreRepository.create(new Genre("fiction"));
        genreRepository.create(new Genre("detective"));

        int size = genreRepository.findAll().size();
        Assert.assertEquals(3, size);
    }

    @Test
    public void testFindByName() {
        String name = "action";
        genreRepository.create(new Genre(name));
        Genre genre = genreRepository.findByName(name);

        assertNotNull(genre);
        assertNotNull(genre.getGenreId());
    }

    @Test
    public void testFindByWrongName() {
        String name = "action";
        genreRepository.create(new Genre(name));
        Genre genre = genreRepository.findByName("1");

        assertNull(genre);
    }

    @Test
    public void testFindById() {
        String name = "action";
        genreRepository.create(new Genre(name));
        Genre genre = genreRepository.findByName(name);
        Genre actualResult = genreRepository.find(genre.getGenreId());

        assertNotNull(actualResult);
    }

    @Test
    public void testFindByWrongId() {
        Genre genre = genreRepository.find(1);

        assertNull(genre);
    }

    @Test
    public void testFindByIds() {
        genreRepository.create(new Genre("action"));
        genreRepository.create(new Genre("fiction"));
        genreRepository.create(new Genre("detective"));
        List<Genre> genres = genreRepository.findAll();
        List<Integer> integers = new ArrayList<>();

        for(Genre g:genres){
            integers.add(g.getGenreId());
        }

        int size = genreRepository.find(integers).size();

        assertEquals(3, size);
    }

    @Test
    public void testFindByWrongIds() {
        genreRepository.create(new Genre("action"));
        genreRepository.create(new Genre("fiction"));
        genreRepository.create(new Genre("detective"));
        List<Genre> genres = genreRepository.findAll();
        List<Integer> integers = new ArrayList<>();

        for(Genre g:genres){
            integers.add(g.getGenreId());
        }
        integers.add(-1);

        List<Genre> actualGenreList = genreRepository.find(integers);

        assertNull(actualGenreList);
    }
}
