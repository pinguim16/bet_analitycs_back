package com.bets.betsApi.service.imp;

import com.bets.betsApi.repository.CompetitionRepository;
import com.bets.betsApi.beans.Competition;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bets.betsApi.service.CompetitionService;

import java.util.List;

@Service
@Transactional
public class CompetitionServiceImp implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    public Competition findById(Long id) {
        return competitionRepository.findById(id).orElse(null);
    }

    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }

    public void delete(Long id) {
        competitionRepository.deleteById(id);
    }
}
