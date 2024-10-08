package controller;

import beans.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bets")
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
        Bet bet = this.betService.updateBet(id,betDetails);
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
    public ResponseEntity<Void> importBets(@RequestBody List<Bet> bets){
      return null;
    }
}
