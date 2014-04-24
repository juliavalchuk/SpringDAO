package ua.epam.spring.library.book;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import ua.epam.spring.library.RepositoryTest;

/**
 * Created by Yuliia_Valchuk on 4/23/2014.
 */
@ContextConfiguration(locations = {"/connectionContextTest.xml","/bookContex.xml"})
public class BookRepositoryJDBCTest extends RepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
}
