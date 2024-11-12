package com.bets.betsApi.beans;

import com.bets.betsApi.beans.enums.BetState;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Entity
@Table(name = "bet")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "bookmaker_id", nullable = false)
    private Bookmaker bookmaker;

    @Column(unique = true)
    private String bookmakerBetId;

    @Enumerated(EnumType.STRING)
    private BetState state;

    @ManyToOne
    @JoinColumn(name = "bet_type_id", nullable = false)
    private BetType betType;

    @ManyToOne
    @JoinColumn(name = "tipster_id", nullable = false)
    private Tipster tipster;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    private Sport sport;  // Relacionamento Many-to-One com Sport

    @ManyToOne
    @JoinColumn(name = "bankroll_id")
    private Bankroll bankroll;

    private Double profit; // Lucro

    private Double totalValue; // valor total recebido

    private Double closing;
    private Double commission;
    private Boolean live;
    private Boolean freebet;
    private Boolean cashout;
    private Boolean eachWay;
    private String comment;
    private String label;
    private Double odds;
    private Double stake;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Bookmaker getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(Bookmaker bookmaker) {
        this.bookmaker = bookmaker;
    }

    public String getBookmakerBetId() {
        return bookmakerBetId;
    }

    public void setBookmakerBetId(String bookmakerBetId) {
        this.bookmakerBetId = bookmakerBetId;
    }

    public BetState getState() {
        return state;
    }

    public void setState(BetState state) {
        this.state = state;
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public Double getStake() {
        return stake;
    }

    public void setStake(Double stake) {
        this.stake = stake;
    }

    public Tipster getTipster() {
        return tipster;
    }

    public void setTipster(Tipster tipster) {
        this.tipster = tipster;
    }

    public Double getClosing() {
        return closing;
    }

    public void setClosing(Double closing) {
        this.closing = closing;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public Boolean getFreebet() {
        return freebet;
    }

    public void setFreebet(Boolean freebet) {
        this.freebet = freebet;
    }

    public Boolean getCashout() {
        return cashout;
    }

    public void setCashout(Boolean cashout) {
        this.cashout = cashout;
    }

    public Boolean getEachWay() {
        return eachWay;
    }

    public void setEachWay(Boolean eachWay) {
        this.eachWay = eachWay;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Bankroll getBankroll() {
        return bankroll;
    }

    public void setBankroll(Bankroll bankroll) {
        this.bankroll = bankroll;
    }

    public Double getProfitLoss() {
        return this.profit;
    }

    /**
     * Calcula o lucro ou prejuízo da aposta com base no estado.
     * Este método deve ser chamado antes de persistir ou atualizar a aposta.
     */
    public void calculateProfitLoss() {

        this.commission = 0.00;
        if (this.odds == null || this.stake == null || this.commission == null) {
            this.profit = 0.0;
            return;
        }
        switch (this.state) {
            case W: // Ganha
                this.profit = (this.odds - 1) * this.stake - this.commission;
                break;
            case HW: // Meio ganho
                this.profit = ((this.odds - 1) * this.stake * 0.5) - (this.commission * 0.5);
                break;
            case L: // Perdida
                this.profit = -this.stake - this.commission;
                break;
            case HL: // Meio perdido
                this.profit = (-this.stake * 0.5) - (this.commission * 0.5);
                break;
            case CASH: // Cashout
                // Implementar lógica específica para Cashout, se aplicável
                // Exemplo: Retornar o valor recebido no cashout menos a comissão
                if (this.totalValue != null) {
                    this.profit = this.totalValue - this.stake - this.commission;
                } else {
                    this.profit = 0.0;
                }
                break;
            case R: // Reembolsada
                this.profit = 0.0;
                break;
            case P: // Pendente
            case C: // Cancelado
                this.profit = 0.0;
                break;
            default:
                this.profit = 0.0;
                break;
        }

        // Garantir que o lucro/prejuízo tenha apenas duas casas decimais
        if (this.profit != null) {
            this.profit = BigDecimal.valueOf(this.profit)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
        }
    }

    // Callbacks do JPA para calcular o lucro/prejuízo antes de persistir ou atualizar
    @PrePersist
    public void prePersist() {
        calculateProfitLoss();
    }

    @PreUpdate
    public void preUpdate() {
        calculateProfitLoss();
    }
}
