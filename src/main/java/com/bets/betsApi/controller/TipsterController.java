package com.bets.betsApi.controller;
import com.bets.betsApi.beans.Tipster;
import com.bets.betsApi.beans.dto.TipsterMetricsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bets.betsApi.service.TipsterService;

import java.util.List;

@RestController
@RequestMapping("/tipsters")
public class TipsterController {

    @Autowired
    private TipsterService tipsterService;

    @GetMapping
    public List<Tipster> getAllTipsters() {
        return tipsterService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipster> getTipsterById(@PathVariable Long id) {
        Tipster tipster = tipsterService.findById(id);
        return tipster != null ? ResponseEntity.ok(tipster) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Tipster createTipster(@RequestBody Tipster tipster) {
        return tipsterService.save(tipster);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipster> updateTipster(@PathVariable Long id, @RequestBody Tipster tipster) {
        tipster.setId(id);
        Tipster updatedTipster = tipsterService.save(tipster);
        return ResponseEntity.ok(updatedTipster);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipster(@PathVariable Long id) {
        tipsterService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/metrics")
    public List<TipsterMetricsDTO> getTipsterMetrics() {
        return tipsterService.getTipsterMetrics();
    }
}
