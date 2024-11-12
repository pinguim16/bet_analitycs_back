package com.bets.betsApi.beans.dto;

public class DistributionDTO {
    private String name;
    private Long count;

    public DistributionDTO(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    // Getters e Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
