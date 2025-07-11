package com.projetojudo.judotexeira.core.usecases.impl;

import com.projetojudo.judotexeira.core.dtos.request.EventoRequest;
import com.projetojudo.judotexeira.core.entities.Evento;
import com.projetojudo.judotexeira.core.gateway.EventoGateway;
import com.projetojudo.judotexeira.core.usecases.EventoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EventoUseCaseImpl implements EventoUseCase {

    private final EventoGateway eventoGateway;



    @Override
    public Evento salvar(EventoRequest evento) {
        return eventoGateway.salvar(evento);
    }

    @Override
    public List<Evento> findAll() {
        return eventoGateway.findAll();
    }

    @Override
    public void deletar(Long id) {
        eventoGateway.deletar(id);
    }
}
