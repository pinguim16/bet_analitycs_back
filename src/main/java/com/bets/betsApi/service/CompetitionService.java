package com.bets.betsApi.service;

import com.bets.betsApi.beans.Competition;

import java.util.List;

public interface CompetitionService {

    List<Competition> findAll();

    Competition findById(Long id);

    Competition save(Competition competition);

    void delete(Long id);
}