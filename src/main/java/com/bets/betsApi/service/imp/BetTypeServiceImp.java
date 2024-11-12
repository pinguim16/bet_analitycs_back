package com.bets.betsApi.service.imp;

import com.bets.betsApi.repository.BetTypeRepository;
import com.bets.betsApi.beans.BetType;
import com.bets.betsApi.service.BetTypeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BetTypeServiceImp implements BetTypeService {

    @Autowired
    private BetTypeRepository betTypeRepository;

    public List<BetType> findAll() {
        return betTypeRepository.findAll();
    }

    public BetType findById(Long id) {
        return betTypeRepository.findById(id).orElse(null);
    }

    public BetType save(BetType betType) {
        return betTypeRepository.save(betType);
    }

    public void delete(Long id) {
        betTypeRepository.deleteById(id);
    }
}
