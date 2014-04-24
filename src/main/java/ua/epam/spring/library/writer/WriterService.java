package ua.epam.spring.library.writer;

import ua.epam.spring.library.writer.Writer;

import java.util.List;

/**
 * Created by Yuliia_Valchuk on 4/23/2014.
 */
public interface WriterService {
    Writer find(Integer id);
    List<Writer> find(List<Integer> ids);
    Writer findByName(String name);
    boolean create(Writer writer);
}
