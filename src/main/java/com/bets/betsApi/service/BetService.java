package com.bets.betsApi.service;

import com.bets.betsApi.beans.Bet;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface BetService {

    List<Bet> getAllBets();

    List<Bet> findAll(Specification<Bet> spec);

    Optional<Bet> getBetById(Long id);

    Bet createBet(Bet bet);

    Bet updateBet(Long id, Bet betDetails);

    void deleteBet(Long id);

    void importBets(List<Bet> bets);

}
