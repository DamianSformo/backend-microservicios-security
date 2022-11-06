package com.dh.serieservice.api.service;

import com.dh.serieservice.domain.model.Serie;
import com.dh.serieservice.shared.GenericServiceAPI;

import java.util.List;

public interface ISerieService extends GenericServiceAPI<Serie, String> {

    List<Serie> getByGenre(String genre);
}
