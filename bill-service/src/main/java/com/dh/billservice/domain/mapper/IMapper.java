package com.dh.billservice.domain.mapper;

public interface IMapper <ENT, RES, REQ>  {

    RES entityToResponseDto(ENT entity);
    ENT responseDtoToEntity(RES responseDto);

    ENT requestDtoToEntity(REQ requestDto);
}
