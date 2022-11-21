package com.dh.billservice.api.service;

import com.dh.billservice.domain.dto.request.BillRequestDto;
import com.dh.billservice.domain.dto.response.BillResponseDto;
import com.dh.billservice.domain.model.Bill;
import com.dh.billservice.domain.dto.response.BillResponseDetailDto;
import com.dh.billservice.shared.GenericServiceAPI;

import java.util.List;

public interface IBillService extends GenericServiceAPI<Bill, BillResponseDto, BillRequestDto, Long> {

    BillResponseDetailDto getById(Long idBill);

    List<BillResponseDetailDto> getByCustomerBill(String username);
}
