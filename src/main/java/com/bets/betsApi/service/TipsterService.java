package com.bets.betsApi.service;

import com.bets.betsApi.beans.Tipster;
import com.bets.betsApi.beans.dto.TipsterMetricsDTO;

import java.util.List;

public interface TipsterService {

    List<Tipster> findAll();

    Tipster findById(Long id);

    Tipster save(Tipster tipster);

    void delete(Long id);

    List<TipsterMetricsDTO> getTipsterMetrics();


}
