package com.bets.betsApi.beans.dto;

public class DashboardMetricsDTO {
    private double totalBankroll;
    private double totalProfitLoss;
    private double roi;
    private double yield;
    private double successRate;

    public double getTotalBankroll() {
        return totalBankroll;
    }

    public void setTotalBankroll(double totalBankroll) {
        this.totalBankroll = totalBankroll;
    }

    public double getTotalProfitLoss() {
        return totalProfitLoss;
    }

    public void setTotalProfitLoss(double totalProfitLoss) {
        this.totalProfitLoss = totalProfitLoss;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    // Outros getters e setters...
}
