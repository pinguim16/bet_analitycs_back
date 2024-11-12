package com.bets.betsApi.controller;

import com.bets.betsApi.beans.Unit;
import com.bets.betsApi.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/units")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping
    public List<Unit> getAllUnits() {
        return unitService.findAll();
    }

    @GetMapping("/{id}")
    public Unit getUnitById(@PathVariable Long id) {
        Optional<Unit> unit = unitService.findById(id);
        return unit.orElse(null);
    }

    @PostMapping
    public Unit createUnit(@RequestBody Unit unit) {
        return unitService.save(unit);
    }

    @PutMapping("/{id}")
    public Unit updateUnit(@PathVariable Long id, @RequestBody Unit unit) {
        unit.setId(id);
        return unitService.save(unit);
    }

    @DeleteMapping("/{id}")
    public void deleteUnit(@PathVariable Long id) {
        unitService.deleteById(id);
    }

    @GetMapping("/tipster/{tipsterId}")
    public List<Unit> getUnitsByTipster(@PathVariable Long tipsterId) {
        return unitService.findByTipsterId(tipsterId);
    }


    // Endpoints adicionais podem ser adicionados aqui, se necessário
}
