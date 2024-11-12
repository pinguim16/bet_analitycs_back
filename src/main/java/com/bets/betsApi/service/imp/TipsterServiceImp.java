package com.bets.betsApi.service.imp;

import com.bets.betsApi.beans.Bet;
import com.bets.betsApi.beans.dto.TipsterMetricsDTO;
import com.bets.betsApi.beans.enums.BetState;
import com.bets.betsApi.repository.BetRepository;
import com.bets.betsApi.repository.TipsterRepository;
import com.bets.betsApi.beans.Tipster;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bets.betsApi.service.TipsterService;

@Service
@Transactional
public class TipsterServiceImp implements TipsterService {

    @Autowired
    private TipsterRepository tipsterRepository;

    @Autowired
    private BetRepository betRepository;

    public List<Tipster> findAll() {
        return tipsterRepository.findAll();
    }

    public Tipster findById(Long id) {
        return tipsterRepository.findById(id).orElse(null);
    }

    public Tipster save(Tipster tipster) {
        return tipsterRepository.save(tipster);
    }

    public void delete(Long id) {
        tipsterRepository.deleteById(id);
    }

    public List<TipsterMetricsDTO> getTipsterMetrics() {
        List<Tipster> tipsters = tipsterRepository.findAll();

        return tipsters.stream().map(tipster -> {
            List<Bet> bets = betRepository.findByTipster(tipster);

            // Cálculo do Lucro/Prejuízo Total usando BigDecimal::add
            BigDecimal totalProfitLoss = bets.stream()
                    .map(bet -> BigDecimal.valueOf(bet.getProfitLoss()))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            Double roi = calculateROI(bets);
            Double successRate = calculateSuccessRate(bets);
            Double averageOdds = calculateAverageOdds(bets);
            BigDecimal averageStake = calculateAverageStake(bets);

            return new TipsterMetricsDTO(
                    tipster.getId(),
                    tipster.getName(),
                    totalProfitLoss,
                    roi,
                    successRate,
                    averageOdds,
                    averageStake
            );
        }).collect(Collectors.toList());
    }

    private Double calculateROI(List<Bet> bets) {
        if (bets.isEmpty()) return 0.0;

        BigDecimal totalStake = bets.stream()
                .map(bet -> BigDecimal.valueOf(bet.getStake()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (totalStake.compareTo(BigDecimal.ZERO) == 0) return 0.0;

        BigDecimal totalProfitLoss = bets.stream()
                .map(bet -> BigDecimal.valueOf(bet.getProfitLoss()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalProfitLoss.divide(totalStake, 4, RoundingMode.HALF_UP).doubleValue();
    }

    private Double calculateSuccessRate(List<Bet> bets) {
        if (bets.isEmpty()) return 0.0;

        long successCount = bets.stream()
                .filter(bet -> bet.getState() == BetState.W || bet.getState() == BetState.HW)
                .count();

        return ((double) successCount / bets.size()) * 100;
    }

    private Double calculateAverageOdds(List<Bet> bets) {
        if (bets.isEmpty()) return 0.0;

        double totalOdds = bets.stream()
                .mapToDouble(Bet::getOdds)
                .sum();

        return totalOdds / bets.size();
    }

    private BigDecimal calculateAverageStake(List<Bet> bets) {
        if (bets.isEmpty()) return BigDecimal.ZERO;

        BigDecimal totalStake = bets.stream()
                .map(bet -> BigDecimal.valueOf(bet.getStake()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalStake.divide(new BigDecimal(bets.size()), 2, RoundingMode.HALF_UP);
    }
}
