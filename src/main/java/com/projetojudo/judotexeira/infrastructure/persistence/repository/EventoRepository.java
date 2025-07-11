package com.projetojudo.judotexeira.infrastructure.persistence.repository;

import com.projetojudo.judotexeira.infrastructure.persistence.entity.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
}
