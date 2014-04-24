package ua.epam.spring.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.library.genre.GenreRepository;
import ua.epam.spring.library.genre.GenreRepositoryJDBCTest;

import java.util.List;

/**
 * Created by Yuliia_Valchuk on 4/24/2014.
 */
public class AppTest {

    public static void main(String[] args) {
        testGenre();
    }

    public static void testGenre(){
        System.out.println("Hello Genre!");

        ApplicationContext appCtx =
                new ClassPathXmlApplicationContext(new String[]{"connectionContextTest.xml", "genreContex.xml", "bookContex.xml", "testContex.xml"});
  //  }
        System.out.println("Buy Genre!");
    }
}
