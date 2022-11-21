package com.dh.billservice.domain.mapper;

import com.dh.billservice.domain.dto.response.BillResponseDetailDto;
import com.dh.billservice.domain.dto.response.UserResponseDetailDto;
import com.dh.billservice.domain.dto.request.BillRequestDto;
import com.dh.billservice.domain.dto.response.BillResponseDto;
import com.dh.billservice.domain.model.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BillMapper implements IMapper<Bill, BillResponseDto, BillRequestDto> {

    @Mapping(source = "userResponseDetailDto.userName", target = "user.userName")
    @Mapping(source = "userResponseDetailDto.firstName", target = "user.firstName")
    @Mapping(source = "userResponseDetailDto.lastName", target = "user.lastName")
    @Mapping(source = "userResponseDetailDto.email", target = "user.email")
    public abstract BillResponseDetailDto billAndUserResponseDetailToBillResponseDetailDto(Bill bill, UserResponseDetailDto userResponseDetailDto);

    @Mapping(source = "userResponseDetailDto.userName", target = "user.userName")
    @Mapping(source = "userResponseDetailDto.firstName", target = "user.firstName")
    @Mapping(source = "userResponseDetailDto.lastName", target = "user.lastName")
    @Mapping(source = "userResponseDetailDto.email", target = "user.email")
    public abstract BillResponseDetailDto entityToBillResponseDetailDto(Bill bill, UserResponseDetailDto userResponseDetailDto);


}
