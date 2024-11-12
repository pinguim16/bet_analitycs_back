package com.bets.betsApi.service.imp;

import com.bets.betsApi.repository.BookmakerRepository;
import com.bets.betsApi.beans.Bookmaker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bets.betsApi.service.BookmakerService;

import java.util.List;

@Service
@Transactional
public class BookmakerServiceImp implements BookmakerService {

    @Autowired
    private BookmakerRepository bookmakerRepository;

    public List<Bookmaker> findAll() {
        return bookmakerRepository.findAll();
    }

    public Bookmaker findById(Long id) {
        return bookmakerRepository.findById(id).orElse(null);
    }

    public Bookmaker save(Bookmaker bookmaker) {
        return bookmakerRepository.save(bookmaker);
    }

    public void delete(Long id) {
        bookmakerRepository.deleteById(id);
    }
}
