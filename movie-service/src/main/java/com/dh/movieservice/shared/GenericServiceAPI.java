package com.dh.movieservice.shared;

import com.dh.movieservice.domain.mapper.IMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<ENT, RES, REQ, ID> {

    RES save(REQ entity);

    void delete(ID id);

    JpaRepository<ENT, ID> getRepository();

    IMapper<ENT, RES, REQ> getMapper();
}
