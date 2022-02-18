package service;

import repository.BaseRepository;

import java.util.List;

public interface BaseService<T> {

    void save(T t);

    void update(T t);

    void delete(int id);

    T findById(int id);

    List<T> findAll();
}
