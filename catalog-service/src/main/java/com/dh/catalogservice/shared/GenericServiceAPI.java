package com.dh.catalogservice.shared;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<T, ID extends Serializable> {

    T save(T entity);

    T getOne(ID id);

    List<T> getAll();

    void delete(ID id);

    MongoRepository<T, ID> getRepository();
}
