package beans;

import beans.enums.BetState;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "competition_id", nullable = false)
    @JsonManagedReference
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "bookmaker_id", nullable = false)
    @JsonBackReference
    private Bookmaker bookmaker;

    @Column(unique = true)
    private String bookmakerBetId;

    @Enumerated(EnumType.STRING)
    private BetState state;

    @ManyToOne
    @JoinColumn(name = "bet_type_id", nullable = false)
    private BetType betType;

    private String label;
    private Double odds;
    private Double stake;

    @ManyToOne
    @JoinColumn(name = "tipster_id", nullable = false)
    private Tipster tipster;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    private Sport sport;  // Relacionamento Many-to-One com Sport

    private Double profit; // Lucro

    private Double totalValue; // valor total recebido

    private Double closing;
    private Double commission;
    private Boolean live;
    private Boolean freebet;
    private Boolean cashout;
    private Boolean eachWay;
    private String comment;

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
}
