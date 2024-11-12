package com.bets.betsApi.repository;

import com.bets.betsApi.beans.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    // Métodos adicionais personalizados podem ser adicionados aqui, se necessário

    List<Unit> findByTipsterId(Long tipsterId);
}