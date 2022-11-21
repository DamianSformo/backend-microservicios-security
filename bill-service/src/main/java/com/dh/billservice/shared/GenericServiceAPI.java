package com.dh.billservice.shared;

import com.dh.billservice.domain.mapper.IMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericServiceAPI<ENT, RES, REQ, ID> {

    RES save(REQ entity);

    void delete(ID id);

    JpaRepository<ENT, ID> getRepository();

    IMapper<ENT, RES, REQ> getMapper();
}
