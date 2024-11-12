package com.bets.betsApi.repository;

import com.bets.betsApi.beans.Bankroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankrollRepository extends JpaRepository<Bankroll, Long> {
    List<Bankroll> findAllByOrderByDateAsc();
    // Métodos adicionais se necessário
}