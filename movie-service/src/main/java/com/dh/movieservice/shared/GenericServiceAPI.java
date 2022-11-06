package com.dh.movieservice.shared;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<T, ID extends Serializable> {

    T save(T entity);

    T getOne(ID id);

    List<T> getAll();

    void delete(ID id);

    JpaRepository<T, ID> getRepository();
}
