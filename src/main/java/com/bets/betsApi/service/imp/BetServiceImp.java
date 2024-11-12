package com.bets.betsApi.service.imp;

import com.bets.betsApi.repository.BetRepository;
import com.bets.betsApi.repository.TipsterRepository;
import com.bets.betsApi.beans.Bet;
import com.bets.betsApi.beans.Tipster;
import com.bets.betsApi.beans.Unit;
import com.bets.betsApi.beans.enums.BetState;
import com.bets.betsApi.service.BetService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BetServiceImp implements BetService {

    @Autowired
    public BetRepository betRepository;

    @Autowired
    public TipsterRepository tipsterRepository;

    @Override
    public List<Bet> getAllBets() {
        return this.betRepository.findAll();
    }

    @Override
    public List<Bet> findAll(Specification<Bet> spec) {
        return betRepository.findAll(spec);
    }

    @Override
    public Optional<Bet> getBetById(Long id) {
        return this.betRepository.findById(id);
    }

    @Override
    public Bet createBet(Bet bet) {
        return betRepository.save(bet);
    }

    @Override
    public Bet updateBet(Long id, Bet betDetails) {
        Optional<Bet> optionalBet = betRepository.findById(id);
        if (optionalBet.isPresent()) {
            Bet bet = optionalBet.get();
            // Atualize os campos necessários
            bet.setDate(betDetails.getDate());
            bet.setBookmaker(betDetails.getBookmaker());
            bet.setBookmakerBetId(betDetails.getBookmakerBetId());
            bet.setState(betDetails.getState());
            bet.setBetType(betDetails.getBetType());
            bet.setLabel(betDetails.getLabel());
            bet.setOdds(betDetails.getOdds());
            bet.setStake(betDetails.getStake());
            bet.setTipster(betDetails.getTipster());
            bet.setCategory(betDetails.getCategory());
            bet.setCompetition(betDetails.getCompetition());
            bet.setClosing(betDetails.getClosing());
            bet.setCommission(betDetails.getCommission());
            bet.setLive(betDetails.getLive());
            bet.setFreebet(betDetails.getFreebet());
            bet.setCashout(betDetails.getCashout());
            bet.setEachWay(betDetails.getEachWay());
            bet.setComment(betDetails.getComment());
            return betRepository.save(bet);
        }
        return null;
    }

    @Override
    public void deleteBet(Long id) {
        Optional<Bet> optionalBet = betRepository.findById(id);
        if (optionalBet.isPresent()) {
            betRepository.delete(optionalBet.get());
        }
    }

    @Override
    public void importBets(List<Bet> bets) {
        List<Tipster> tipsterList = this.tipsterRepository.findAll();
        this.compareBetStakeWithTipsterUnits(bets,tipsterList);

        for (Bet bet : bets){
            if(bet.getState().equals(BetState.W)){
                Double valueTotal = bet.getOdds() * bet.getStake();
                bet.setTotalValue(valueTotal);

                Double profit = valueTotal - bet.getStake();
                bet.setProfit(profit);
            }
            if(bet.getState().equals(BetState.L)){ // entra como perda
                Double valueTotal = - bet.getStake();
                bet.setTotalValue(valueTotal);

                Double profit = - valueTotal;
                bet.setProfit(profit);
            }
        }
    }

    //encontrando tipster para apostas
    private void compareBetStakeWithTipsterUnits(List<Bet> bets, List<Tipster> tipsterList) {
        for (Bet bet : bets) {
            for (Tipster tipster : tipsterList) {
                List<Unit> units = tipster.getUnits();  // Obter as unidades do tipster
                // Comparar a stake da aposta com as unidades do tipster
                for (Unit unit : units) {
                    if (bet.getStake().equals(unit.getValue())) {
                        bet.setTipster(tipster);
                        bet.setSport(tipster.getSport());
                    } else {
                        bet.setTipster(tipster);
                    }
                }
            }
        }
    }

}