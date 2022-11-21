package com.dh.billservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BillNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BillNotFoundException(Long idBill) {
        super(String.format("Bill with idBill '%s' not found", idBill));
    }
}