package com.dh.serieservice.api.service;

import com.dh.serieservice.domain.model.Serie;
import com.dh.serieservice.domain.repository.SerieRepository;
import com.dh.serieservice.queue.SerieSender;
import com.dh.serieservice.shared.GenericServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService extends GenericServiceImpl<Serie, String> implements ISerieService{

    private final SerieRepository serieRepository;

    private final SerieSender sender;

    @Override
    public List<Serie> getByGenre(String genre) {
        return serieRepository.getByGenre(genre);
    }

    @Override
    public Serie save(Serie entity) {
        var serieDB = super.save(entity);
        sender.sendSerie(serieDB);
        return serieDB;
    }

    @Override
    public MongoRepository<Serie, String> getRepository() {
        return serieRepository;
    }
}
