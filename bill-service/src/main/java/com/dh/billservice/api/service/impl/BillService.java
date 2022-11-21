package com.dh.billservice.api.service.impl;

import com.dh.billservice.api.client.UserServiceClient;
import com.dh.billservice.api.service.IBillService;
import com.dh.billservice.domain.dto.response.BillResponseDetailDto;
import com.dh.billservice.domain.dto.response.UserResponseDetailDto;
import com.dh.billservice.domain.mapper.BillMapper;
import com.dh.billservice.domain.mapper.IMapper;
import com.dh.billservice.exception.BillNotFoundException;
import com.dh.billservice.shared.GenericServiceImpl;
import com.dh.billservice.domain.dto.request.BillRequestDto;
import com.dh.billservice.domain.dto.response.BillResponseDto;
import com.dh.billservice.domain.model.Bill;
import com.dh.billservice.domain.repository.BillRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class BillService extends GenericServiceImpl<Bill, BillResponseDto, BillRequestDto, Long> implements IBillService {

  private final BillRepository billRepository;
  private final BillMapper billMapper;

  private final UserServiceClient userServiceClient;

  public BillResponseDto save(BillRequestDto billRequestDto) {
    log.info("Factura agregada correctamente");
    return super.save(billRequestDto);
  }

  @Override
  public List<BillResponseDetailDto> getByCustomerBill(String username) {
    List<Bill> bills = billRepository.getByCustomerBill(username);
    List<BillResponseDetailDto> billResponseDetailDtos = new ArrayList<>();
    UserResponseDetailDto userResponseDetailDto = userServiceClient.findByUserName(username).getBody();
    bills.forEach(bill -> billResponseDetailDtos.add(billMapper.billAndUserResponseDetailToBillResponseDetailDto(bill, userResponseDetailDto)));
    return billResponseDetailDtos;
  }

  @Override
  public BillResponseDetailDto getById(Long idBill) throws BillNotFoundException {
    Optional<Bill> bill = billRepository.findById(idBill);
    UserResponseDetailDto userResponseDetailDto = userServiceClient.findByUserName(bill.get().getCustomerBill()).getBody();
    return billMapper.entityToBillResponseDetailDto(billRepository.findById(idBill).orElseThrow(() -> new BillNotFoundException(idBill)), userServiceClient.findByUserName(bill.get().getCustomerBill()).getBody());
  }

  public void delete(Long imdbId) {
    getById(imdbId);
    super.delete(imdbId);
    log.info("Factura eliminada correctamente");
  }

  @Override
  public JpaRepository<Bill, Long> getRepository() {
    return billRepository;
  }

  @Override
  public IMapper<Bill, BillResponseDto, BillRequestDto> getMapper() {
    return billMapper;
  }

}
