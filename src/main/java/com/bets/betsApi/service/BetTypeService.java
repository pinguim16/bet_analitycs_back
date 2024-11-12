package com.bets.betsApi.service;

import com.bets.betsApi.beans.BetType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BetTypeService {

    List<BetType> findAll() ;

    BetType findById(Long id);

    BetType save(BetType betType);

    void delete(Long id);
}
