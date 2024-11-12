package com.bets.betsApi.controller;

import com.bets.betsApi.beans.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bets.betsApi.service.CompetitionService;

import java.util.List;

@RestController
@RequestMapping("/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping
    public List<Competition> getAllCompetitions() {
        return competitionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable Long id) {
        Competition competition = competitionService.findById(id);
        return competition != null ? ResponseEntity.ok(competition) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Competition createCompetition(@RequestBody Competition competition) {
        return competitionService.save(competition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> updateCompetition(@PathVariable Long id, @RequestBody Competition competition) {
        competition.setId(id);
        Competition updatedCompetition = competitionService.save(competition);
        return ResponseEntity.ok(updatedCompetition);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable Long id) {
        competitionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
