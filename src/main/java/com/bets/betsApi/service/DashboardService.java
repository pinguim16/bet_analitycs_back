package com.bets.betsApi.service;

import com.bets.betsApi.beans.Bet;
import com.bets.betsApi.beans.dto.BankrollEvolutionDTO;
import com.bets.betsApi.beans.dto.DashboardMetricsDTO;
import com.bets.betsApi.beans.dto.DistributionDTO;

import java.util.List;

public interface DashboardService {

    DashboardMetricsDTO getDashboardMetrics();

    List<BankrollEvolutionDTO> getBankrollEvolution();

    List<DistributionDTO> getBetDistributionBySport();

    List<DistributionDTO> getBetDistributionByTipster();

    List<DistributionDTO> getBetDistributionByCategory();

}
