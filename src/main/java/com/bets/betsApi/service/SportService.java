package com.bets.betsApi.service;

import com.bets.betsApi.beans.Sport;

import java.util.List;

public interface SportService {

    List<Sport> findAll();

    Sport findById(Long id);

    Sport save(Sport sport);

    void delete(Long id);

}
