package com.bets.betsApi.repository;

import com.bets.betsApi.beans.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
