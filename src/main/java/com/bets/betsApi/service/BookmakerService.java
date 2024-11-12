package com.bets.betsApi.service;

import com.bets.betsApi.beans.Bookmaker;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookmakerService {

    List<Bookmaker> findAll();

    Bookmaker findById(Long id);

    Bookmaker save(Bookmaker bookmaker);

    void delete(Long id);
}
