package com.bets.betsApi.service;

import com.bets.betsApi.beans.Bankroll;

import java.util.List;
import java.util.Optional;

public interface BankrollService {
    List<Bankroll> findAll();

    Optional<Bankroll> findById(Long id);

    Bankroll save(Bankroll bankroll);

    void deleteById(Long id);

}
