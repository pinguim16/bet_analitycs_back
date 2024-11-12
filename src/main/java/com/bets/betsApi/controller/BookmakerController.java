package com.bets.betsApi.controller;

import com.bets.betsApi.beans.Bookmaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bets.betsApi.service.BookmakerService;

import java.util.List;

@RestController
@RequestMapping("/bookmakers")
public class BookmakerController {

    @Autowired
    private BookmakerService bookmakerService;

    @GetMapping
    public List<Bookmaker> getAllBookmakers() {
        return bookmakerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookmaker> getBookmakerById(@PathVariable Long id) {
        Bookmaker bookmaker = bookmakerService.findById(id);
        return bookmaker != null ? ResponseEntity.ok(bookmaker) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Bookmaker createBookmaker(@RequestBody Bookmaker bookmaker) {
        return bookmakerService.save(bookmaker);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bookmaker> updateBookmaker(@PathVariable Long id, @RequestBody Bookmaker bookmaker) {
        bookmaker.setId(id);
        Bookmaker updatedBookmaker = bookmakerService.save(bookmaker);
        return ResponseEntity.ok(updatedBookmaker);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookmaker(@PathVariable Long id) {
        bookmakerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
