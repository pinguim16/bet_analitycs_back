package com.bets.betsApi.repository;

import com.bets.betsApi.beans.BetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetTypeRepository extends JpaRepository<BetType, Long> {
}
