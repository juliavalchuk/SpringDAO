package ua.epam.spring.repository;

import java.util.List;

/**
 * Created by julia
 */
public interface IdIdBookRepository<T> {
    T find(Integer id);
    List<T> findByBookId(Integer id);
    List<T> findByAnotherId(Integer id);
    List<T> findAll();
    boolean create(T writer);
}
