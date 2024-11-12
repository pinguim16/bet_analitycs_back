package com.bets.betsApi.beans.dto;

import java.time.LocalDateTime;

public class BankrollEvolutionDTO {
    private LocalDateTime date;
    private double total;

    public BankrollEvolutionDTO(LocalDateTime date, double total) {
        this.date = date;
        this.total = total;
    }

    // Getters e Setters

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}