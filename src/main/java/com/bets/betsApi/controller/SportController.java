package com.bets.betsApi.controller;

import com.bets.betsApi.beans.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bets.betsApi.service.SportService;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping
    public List<Sport> getAllSports() {
        return sportService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sport> getSportById(@PathVariable Long id) {
        Sport sport = sportService.findById(id);
        return sport != null ? ResponseEntity.ok(sport) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Sport createSport(@RequestBody Sport sport) {
        return sportService.save(sport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sport> updateSport(@PathVariable Long id, @RequestBody Sport sport) {
        sport.setId(id);
        Sport updatedSport = sportService.save(sport);
        return ResponseEntity.ok(updatedSport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSport(@PathVariable Long id) {
        sportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
