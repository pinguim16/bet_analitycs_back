package com.bets.betsApi.service;

import com.bets.betsApi.beans.Unit;

import java.util.List;
import java.util.Optional;

public interface UnitService {

    List<Unit> findAll();

    Optional<Unit> findById(Long id);

    Unit save(Unit unit);

    void deleteById(Long id);

    List<Unit> findByTipsterId(Long tipsterId);
}
