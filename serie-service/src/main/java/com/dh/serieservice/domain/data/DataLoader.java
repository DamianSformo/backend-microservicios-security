package com.dh.serieservice.domain.data;

import com.dh.serieservice.api.service.ISerieService;
import com.dh.serieservice.domain.model.Chapter;
import com.dh.serieservice.domain.model.Season;
import com.dh.serieservice.domain.model.Serie;
import com.dh.serieservice.domain.repository.SerieRepository;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final ISerieService service;

    public DataLoader(ISerieService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var chapter1 = new Chapter();
        chapter1.setName("a");
        chapter1.setNumber(1);
        chapter1.setUrlStream("url");

        var chapter2 = new Chapter();
        chapter2.setName("b");
        chapter2.setNumber(2);
        chapter2.setUrlStream("url");

        List<Chapter> chapters1 = new ArrayList<>();
        chapters1.add(chapter1);
        chapters1.add(chapter2);

        var season1 = new Season();
        season1.setSeasonNumber(1);
        season1.setChapters(chapters1);

        var season2 = new Season();
        season2.setSeasonNumber(2);

        List<Season> seasons1 = new ArrayList<>();
        seasons1.add(season1);
        seasons1.add(season2);

        var serie1 = new Serie();
        serie1.setName("slasher");
        serie1.setGenre("terror");
        serie1.setSeasons(seasons1);

        var sDB1 = service.save(serie1);
        log.info(sDB1.toString());

        var serie2 = new Serie();
        serie2.setName("archivo 81");
        serie2.setGenre("terror");

        var sDB2 = service.save(serie2);
        log.info(sDB2.toString());

        var serie3 = new Serie();
        serie3.setName("escandalosos");
        serie3.setGenre("animación");

        var sDB3 = service.save(serie3);
        log.info(sDB3.toString());

    }
}
