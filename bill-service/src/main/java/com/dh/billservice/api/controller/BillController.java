package com.dh.billservice.api.controller;

import com.dh.billservice.domain.dto.response.BillResponseDetailDto;
import com.dh.billservice.api.client.UserServiceClient;
import com.dh.billservice.domain.dto.request.BillRequestDto;
import com.dh.billservice.api.service.impl.BillService;
import com.dh.billservice.domain.dto.response.BillResponseDto;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
public class BillController {

  private final BillService billService;

  private final UserServiceClient userServiceClient;

  public BillController(BillService billService, UserServiceClient userServiceClient) {
    this.billService = billService;
    this.userServiceClient = userServiceClient;
  }

  @PostMapping("/save")
  @PreAuthorize("hasRole('ROLE_PROVIDER')")
  public ResponseEntity<BillResponseDto> save(@RequestBody BillRequestDto billRequestDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(billService.save(billRequestDto));
  }

  @GetMapping("/detail/{userName}")
  @PreAuthorize("hasRole('ROLE_PROVIDER') or hasRole('ROLE_CLIENT')")
  public ResponseEntity<List<BillResponseDetailDto>> getByUsername(@PathVariable String userName) {
    return ResponseEntity.ok().body(billService.getByCustomerBill(userName));
  }

  @DeleteMapping("/{idBill}")
  @PreAuthorize("hasRole('ROLE_PROVIDER')")
  public ResponseEntity<Void> delete(@PathVariable Long idBill) {
    billService.delete(idBill);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
