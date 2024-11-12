package com.bets.betsApi.controller;

import com.bets.betsApi.beans.BetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bets.betsApi.service.BetTypeService;

import java.util.List;

@RestController
@RequestMapping("/bet-types")
public class BetTypeController {

    @Autowired
    private BetTypeService betTypeService;

    @GetMapping
    public List<BetType> getAllBetTypes() {
        return betTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BetType> getBetTypeById(@PathVariable Long id) {
        BetType betType = betTypeService.findById(id);
        return betType != null ? ResponseEntity.ok(betType) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public BetType createBetType(@RequestBody BetType betType) {
        return betTypeService.save(betType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BetType> updateBetType(@PathVariable Long id, @RequestBody BetType betType) {
        betType.setId(id);
        BetType updatedBetType = betTypeService.save(betType);
        return ResponseEntity.ok(updatedBetType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBetType(@PathVariable Long id) {
        betTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
