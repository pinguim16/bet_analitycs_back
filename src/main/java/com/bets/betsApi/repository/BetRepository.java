package com.bets.betsApi.repository;

import com.bets.betsApi.beans.Bet;
import com.bets.betsApi.beans.Tipster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long>, JpaSpecificationExecutor<Bet> {

    List<Bet> findByTipster(Tipster tipster);

    // Métodos personalizados, se necessário
}
