package com.bets.betsApi.service.imp;

import com.bets.betsApi.beans.Bet;
import com.bets.betsApi.repository.BankrollRepository;
import com.bets.betsApi.beans.Bankroll;
import com.bets.betsApi.service.BankrollService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class BankrollServiceImp implements BankrollService {

    @Autowired
    private BankrollRepository bankrollRepository;

    @Override
    public List<Bankroll> findAll() {
        return bankrollRepository.findAll();
    }

    @Override
    public Optional<Bankroll> findById(Long id) {
        return bankrollRepository.findById(id);
    }

    public Bankroll save(Bankroll bankroll) {
        return bankrollRepository.save(bankroll);
    }

    public void deleteById(Long id) {
        bankrollRepository.deleteById(id);
    }

}
