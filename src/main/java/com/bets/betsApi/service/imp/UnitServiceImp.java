package com.bets.betsApi.service.imp;

import com.bets.betsApi.beans.Unit;
import com.bets.betsApi.repository.UnitRepository;
import com.bets.betsApi.service.UnitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UnitServiceImp implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    @Override
    public Optional<Unit> findById(Long id) {
        return unitRepository.findById(id);
    }

    @Override
    public Unit save(Unit unit) {
        return unitRepository.save(unit);
    }
    @Override
    public void deleteById(Long id) {
        unitRepository.deleteById(id);
    }

    public List<Unit> findByTipsterId(Long tipsterId) {
        return unitRepository.findByTipsterId(tipsterId);
    }

}
