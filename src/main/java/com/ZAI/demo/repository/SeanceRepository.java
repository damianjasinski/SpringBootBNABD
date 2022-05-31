package com.ZAI.demo.repository;

import com.ZAI.demo.models.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {
    Optional<Seance> findBySeanceDate(LocalDateTime newDateTime);
}

