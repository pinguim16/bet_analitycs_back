package com.bets.betsApi.beans.dto;

import java.math.BigDecimal;

public class TipsterMetricsDTO {

    private Long id;
    private String name;
    private BigDecimal totalProfitLoss;
    private Double roi;
    private Double successRate;
    private Double averageOdds;
    private BigDecimal averageStake;

    // Construtores
    public TipsterMetricsDTO() {
    }

    public TipsterMetricsDTO(Long id, String name, BigDecimal totalProfitLoss, Double roi, Double successRate, Double averageOdds, BigDecimal averageStake) {
        this.id = id;
        this.name = name;
        this.totalProfitLoss = totalProfitLoss;
        this.roi = roi;
        this.successRate = successRate;
        this.averageOdds = averageOdds;
        this.averageStake = averageStake;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalProfitLoss() {
        return totalProfitLoss;
    }

    public void setTotalProfitLoss(BigDecimal totalProfitLoss) {
        this.totalProfitLoss = totalProfitLoss;
    }

    public Double getRoi() {
        return roi;
    }

    public void setRoi(Double roi) {
        this.roi = roi;
    }

    public Double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Double successRate) {
        this.successRate = successRate;
    }

    public Double getAverageOdds() {
        return averageOdds;
    }

    public void setAverageOdds(Double averageOdds) {
        this.averageOdds = averageOdds;
    }

    public BigDecimal getAverageStake() {
        return averageStake;
    }

    public void setAverageStake(BigDecimal averageStake) {
        this.averageStake = averageStake;
    }
}
