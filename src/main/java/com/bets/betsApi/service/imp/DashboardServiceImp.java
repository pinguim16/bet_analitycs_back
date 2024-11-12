package com.bets.betsApi.service.imp;


import com.bets.betsApi.beans.Bankroll;
import com.bets.betsApi.beans.Bet;
import com.bets.betsApi.beans.dto.BankrollEvolutionDTO;
import com.bets.betsApi.beans.dto.DashboardMetricsDTO;
import com.bets.betsApi.beans.dto.DistributionDTO;
import com.bets.betsApi.repository.BankrollRepository;
import com.bets.betsApi.repository.BetRepository;
import com.bets.betsApi.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImp implements DashboardService {

    @Autowired
    private BetRepository betRepository;

    @Autowired
    private BankrollRepository bankrollRepository;

    @Override
    public DashboardMetricsDTO getDashboardMetrics() {
        List<Bet> bets = betRepository.findAll();

        double totalBankroll = calculateTotalBankroll(bets);
        double totalProfitLoss = calculateTotalProfitLoss(bets);
        double roi = calculateROI(bets);
        double yield = calculateYield(bets);
        double successRate = calculateSuccessRate(bets);
        // Outros cálculos conforme necessário

        DashboardMetricsDTO metrics = new DashboardMetricsDTO();
        metrics.setTotalBankroll(totalBankroll);
        metrics.setTotalProfitLoss(totalProfitLoss);
        metrics.setRoi(roi);
        metrics.setYield(yield);
        metrics.setSuccessRate(successRate);
        // Defina outros campos

        return metrics;
    }

    // Implementação dos métodos de cálculo

    private double calculateTotalBankroll(List<Bet> bets) {
        return bets.stream()
                .mapToDouble(Bet::getProfit)
                .sum();
    }

    private double calculateTotalProfitLoss(List<Bet> bets) {
        return bets.stream()
                .mapToDouble(bet -> bet.getProfit() != null ? bet.getProfit() : 0)
                .sum();
    }

    private double calculateROI(List<Bet> bets) {
        double totalStake = bets.stream()
                .mapToDouble(Bet::getStake)
                .sum();
        if (totalStake == 0) return 0;
        double totalProfit = calculateTotalProfitLoss(bets);
        return totalProfit / totalStake;
    }

    private double calculateYield(List<Bet> bets) {
        double totalStake = bets.stream()
                .mapToDouble(Bet::getStake)
                .sum();
        if (totalStake == 0) return 0;
        double totalProfit = calculateTotalProfitLoss(bets);
        return totalProfit / totalStake;
    }

    private double calculateSuccessRate(List<Bet> bets) {
        if (bets == null || bets.isEmpty()) {
            return 0.0;
        }
        long totalBets = bets.size();
        long successfulBets = bets.stream()
                .filter(bet -> bet != null && bet.getState() != null && bet.getState().isSuccess())
                .count();

        return (double) successfulBets / totalBets;
    }

    @Override
    public List<BankrollEvolutionDTO> getBankrollEvolution() {
        List<Bankroll> bankrollHistory = bankrollRepository.findAllByOrderByDateAsc();
        return bankrollHistory.stream()
                .map(bankroll -> new BankrollEvolutionDTO(bankroll.getDate(), bankroll.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DistributionDTO> getBetDistributionBySport() {
        return betRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        bet -> bet.getSport().getName(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .map(entry -> new DistributionDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DistributionDTO> getBetDistributionByTipster() {
        return betRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        bet -> bet.getTipster().getName(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .map(entry -> new DistributionDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DistributionDTO> getBetDistributionByCategory() {
        return betRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        bet -> bet.getCategory().getName(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .map(entry -> new DistributionDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    // Métodos para outras métricas...
}
