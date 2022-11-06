package com.dh.userservice.shared;

import com.dh.userservice.Exceptions.ResourceNotFoundException;

import java.io.Serializable;

public interface GenericServiceAPI<T, ID extends Serializable> {

    T save(T entity);

    void delete(ID id) throws ResourceNotFoundException;

}
