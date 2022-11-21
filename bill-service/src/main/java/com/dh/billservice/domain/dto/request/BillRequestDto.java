package com.dh.billservice.domain.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class BillRequestDto {

    private Long idBill;

    private Date billingDate;

    private String customerBill;

    private String productBill;

    private Double totalPrice;
}
