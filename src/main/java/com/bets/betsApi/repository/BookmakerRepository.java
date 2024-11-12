package com.bets.betsApi.repository;

import com.bets.betsApi.beans.Bookmaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmakerRepository extends JpaRepository<Bookmaker, Long> {
}
