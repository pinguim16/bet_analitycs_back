package com.bets.betsApi.controller;

import com.bets.betsApi.beans.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bets.betsApi.predicate.BetSpecification;
import com.bets.betsApi.service.BetService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bets")
public class BetController {

    @Autowired
    private BetService betService;

    // GET: Listar todas as apostas
    @GetMapping
    public List<Bet> getAllBets() {
        return this.betService.getAllBets();
    }

    // GET: Buscar uma aposta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Bet> getBetById(@PathVariable Long id) {
        Optional<Bet> bet = this.betService.getBetById(id);
        return bet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Criar uma nova aposta
    @PostMapping
    public Bet createBet(@RequestBody Bet bet) {
        return this.betService.createBet(bet);
    }

    // PUT: Atualizar uma aposta existente
    @PutMapping("/{id}")
    public ResponseEntity<Bet> updateBet(@PathVariable Long id, @RequestBody Bet betDetails) {
        Bet bet = this.betService.updateBet(id, betDetails);
        if (bet != null) {
            return ResponseEntity.ok(bet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Deletar uma aposta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBet(@PathVariable Long id) {
        if (id != null) {
            this.betService.deleteBet(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/import")
    public ResponseEntity<Void> importBets(@RequestBody List<Bet> bets) {
        return null;
    }

    @GetMapping("/filter")
    public List<Bet> getAllBets(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam(required = false) Long competitionId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long bookmakerId,
            @RequestParam(required = false) String bookmakerBetId,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) Long betTypeId,
            @RequestParam(required = false) String label,
            @RequestParam(required = false) Double odds,
            @RequestParam(required = false) Double stake,
            @RequestParam(required = false) Long tipsterId,
            @RequestParam(required = false) Long sportId,
            @RequestParam(required = false) Double profit,
            @RequestParam(required = false) Double totalValue,
            @RequestParam(required = false) Double closing,
            @RequestParam(required = false) Double commission,
            @RequestParam(required = false) Boolean live,
            @RequestParam(required = false) Boolean freebet,
            @RequestParam(required = false) Boolean cashout,
            @RequestParam(required = false) Boolean eachWay,
            @RequestParam(required = false) String comment
    ) {
        Specification<Bet> spec = BetSpecification.filter(
                id, date, competitionId, categoryId, bookmakerId, bookmakerBetId, state,
                betTypeId, label, odds, stake, tipsterId, sportId, profit, totalValue,
                closing, commission, live, freebet, cashout, eachWay, comment
        );
        return betService.findAll(spec);
    }
}

