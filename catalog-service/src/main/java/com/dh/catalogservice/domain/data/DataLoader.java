package com.dh.catalogservice.domain.data;

import com.dh.catalogservice.api.service.ICatalogService;
import com.dh.catalogservice.domain.model.Catalog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final ICatalogService service;

    public DataLoader(ICatalogService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var catalog1 = new Catalog();
        catalog1.setGenre("terror");

        if(service.getByGenre(catalog1.getGenre()) == null){
            var cDB1 = service.save(catalog1);
            log.info(cDB1.toString());
        }

    }
}
