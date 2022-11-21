package com.dh.billservice.domain.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class BillResponseDto {

    private Long idBill;

    private Date billingDate;

    private String customerBill;

    private String productBill;

    private Double totalPrice;
}
