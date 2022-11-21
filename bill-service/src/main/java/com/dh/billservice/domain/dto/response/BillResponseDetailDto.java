package com.dh.billservice.domain.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class BillResponseDetailDto {

    private String idBill;

    private Date billingDate;

    private Double totalPrice;

    private User user;
}
