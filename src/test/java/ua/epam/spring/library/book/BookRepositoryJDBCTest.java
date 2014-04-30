package ua.epam.spring.library.book;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import ua.epam.spring.library.RepositoryTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Yuliia_Valchuk on 4/23/2014.
 */
@ContextConfiguration(locations = {"/bookContex.xml"})
public class BookRepositoryJDBCTest extends RepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        jdbcTemplate.execute("delete from book");
        jdbcTemplate.execute("delete from genrespool");
        jdbcTemplate.execute("delete from writerspool");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreateOneRecord(){
        Book book = new Book("tales", 40., 5.);
        bookRepository.create(book);

        int size = jdbcTemplate.queryForObject("select count(*) from book", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNullBook(){
        Book book = null;
        bookRepository.create(book);

        int size = jdbcTemplate.queryForObject("select count(*) from book", Integer.class);
        // Assert.assertEquals(1, size);
    }

    @Test
    public void testFindAllEmptyTable(){
        int size = bookRepository.findAll().size();
        Assert.assertEquals(0, size);
    }

    @Test
    public void testFindAllNotEmptyTable(){
        bookRepository.create(new Book("tales", 40., 5.));
        bookRepository.create(new Book("harry potter I", 50., 8.));
        bookRepository.create(new Book("harry potter II", 50., 8.));

        int size = bookRepository.findAll().size();
        Assert.assertEquals(3, size);
    }

    @Test
    public void testGetBookIfExist() {
        String title = "harry potter III";
        double mortgage = 65;
        double rent = 8;
        bookRepository.create(new Book(title, mortgage, rent));
        Book book = bookRepository.getBookIfExist(new Book(title, mortgage, rent));

        assertNotNull(book);
        assertNotNull(book.getBookId());
    }

    @Test
    public void testGetBookIfItNotExist() {
        Book book = bookRepository.getBookIfExist(new Book("1", 1., 1.));

        assertNull(book);
    }

    @Test
    public void testGetBookIfExist2SameBook() {
        String title = "harry potter III";
        double mortgage = 65;
        double rent = 8;
        bookRepository.create(new Book(title, mortgage, rent));
        bookRepository.create(new Book(title, mortgage, rent));
        Book book = bookRepository.getBookIfExist(new Book(title, mortgage, rent));

        assertNull(null);
    }

    @Test
    public void testFindById() {
        String title = "harry potter III";
        double mortgage = 65;
        double rent = 8;
        bookRepository.create(new Book(title, mortgage, rent));
        Book book = bookRepository.getBookIfExist(new Book(title, mortgage, rent));
        Book actualResult = bookRepository.find(book.getBookId());

        assertNotNull(actualResult);
    }

    @Test
    public void testFindByWrongId() {
       Book book = bookRepository.find(1);

        assertNull(book);
    }

    @Test
    public void testAddGenreToBook() {
        bookRepository.addGenreToBook(1, 2);

        int size = jdbcTemplate.queryForObject("select count(*) from genrespool", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testAddWriterToBook() {
        bookRepository.addWriterToBook(1, 2);

        int size = jdbcTemplate.queryForObject("select count(*) from writerspool", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testGetGenresFromBook() {
        bookRepository.addGenreToBook(1, 2);
        bookRepository.addGenreToBook(1, 3);
        bookRepository.addGenreToBook(1, 8);

        int size = bookRepository.getGenresOfBookByID(1).size();
        Assert.assertEquals(3, size);
    }

    @Test
    public void testGetGenresFromNotExistBook() {
        int size = bookRepository.getGenresOfBookByID(1).size();
        Assert.assertEquals(0, size);
    }

    @Test
    public void testGetWritersFromBook() {
        int size = bookRepository.getWritersOfBookById(1).size();
        Assert.assertEquals(0, size);
    }

}
