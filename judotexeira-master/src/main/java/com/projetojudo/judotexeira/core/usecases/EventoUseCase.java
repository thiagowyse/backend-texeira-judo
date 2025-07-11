package com.projetojudo.judotexeira.core.usecases;

import com.projetojudo.judotexeira.core.dtos.request.EventoRequest;
import com.projetojudo.judotexeira.core.entities.Evento;

import java.util.List;

public interface EventoUseCase {

    Evento salvar(EventoRequest evento);
    List<Evento> findAll();
    void deletar(Long id);
}
