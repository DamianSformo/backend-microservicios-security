package com.dh.billservice.domain.data;

import com.dh.billservice.api.service.IBillService;
import com.dh.billservice.domain.dto.request.BillRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final IBillService billService;

    public DataLoader(IBillService billService) {
        this.billService = billService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var billRequestDto1 = new BillRequestDto();
        billRequestDto1.setCustomerBill("client");
        billRequestDto1.setProductBill("product 01");
        billRequestDto1.setTotalPrice(200.75);

        var bDB1 = billService.save(billRequestDto1);
        log.info(bDB1.toString());

        var billRequestDto2 = new BillRequestDto();
        billRequestDto2.setCustomerBill("admin");
        billRequestDto2.setProductBill("product 02");
        billRequestDto2.setTotalPrice(100.0);

        var bDB2 = billService.save(billRequestDto2);
        log.info(bDB2.toString());

        var billRequestDto3 = new BillRequestDto();
        billRequestDto3.setCustomerBill("provider");
        billRequestDto3.setProductBill("product 03");
        billRequestDto3.setTotalPrice(10.25);

        var bDB3 = billService.save(billRequestDto3);
        log.info(bDB3.toString());

    }
}
