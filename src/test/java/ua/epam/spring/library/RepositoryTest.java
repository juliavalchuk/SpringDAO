package ua.epam.spring.library;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Yuliia_Valchuk on 4/23/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/connectionContextTest.xml"})
public abstract class RepositoryTest {
    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
