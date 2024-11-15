package com.bets.betsApi.beans.enums;

public enum BetState {
    P("Pendente"),
    W("Ganha"),
    L("Perdida"),
    R("Reembolsada"),
    HW("Meio ganho"),
    HL("Meio perdido"),
    CASH("Cashout"),
    C("Cancelado");

    private final String description;

    BetState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSuccess() {
        return this == W || this == HW || this == CASH;
    }
}