package com.bets.betsApi.service.imp;

import com.bets.betsApi.repository.SportRepository;
import com.bets.betsApi.beans.Sport;
import com.bets.betsApi.service.SportService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SportServiceImp implements SportService {

    @Autowired
    private SportRepository sportRepository;

    public List<Sport> findAll() {
        return sportRepository.findAll();
    }

    public Sport findById(Long id) {
        return sportRepository.findById(id).orElse(null);
    }

    public Sport save(Sport sport) {
        return sportRepository.save(sport);
    }

    public void delete(Long id) {
        sportRepository.deleteById(id);
    }
}
