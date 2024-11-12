package com.bets.betsApi.repository;

import com.bets.betsApi.beans.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
}
