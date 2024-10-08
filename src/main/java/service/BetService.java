package service;

import beans.Bet;

import java.util.List;
import java.util.Optional;

public interface BetService {

    List<Bet> getAllBets();

    Optional<Bet> getBetById(Long id);

    Bet createBet(Bet bet);

    Bet updateBet(Long id, Bet betDetails);

    void deleteBet(Long id);

    void importBets(List<Bet> bets);

}
