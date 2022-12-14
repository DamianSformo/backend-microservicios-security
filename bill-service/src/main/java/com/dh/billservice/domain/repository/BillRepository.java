package com.dh.billservice.domain.repository;

import com.dh.billservice.domain.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface BillRepository extends JpaRepository<Bill, Long> {

  @Query("SELECT b FROM Bill b WHERE b.customerBill = ?1")
  List<Bill> getByCustomerBill(String username);

}
