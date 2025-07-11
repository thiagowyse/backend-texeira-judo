package com.projetojudo.judotexeira.infrastructure.gateway;

import com.projetojudo.judotexeira.core.dtos.request.EventoRequest;
import com.projetojudo.judotexeira.core.entities.Evento;
import com.projetojudo.judotexeira.core.gateway.EventoGateway;
import com.projetojudo.judotexeira.infrastructure.mapper.EventoDtoMapper;
import com.projetojudo.judotexeira.infrastructure.mapper.EventoEntityMapper;
import com.projetojudo.judotexeira.infrastructure.persistence.entity.EventoEntity;
import com.projetojudo.judotexeira.infrastructure.persistence.repository.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EventoGatewayImpl implements EventoGateway {

    private final EventoRepository eventoRepository;

    @Override
    public Evento salvar(EventoRequest eventoRequest) {
        Evento eventoDomain = EventoDtoMapper.toDomain(eventoRequest);
        EventoEntity eventoEntity = EventoEntityMapper.toEntity(eventoDomain);
        EventoEntity savedEntity = eventoRepository.save(eventoEntity);
        return EventoEntityMapper.toDomain(savedEntity);
    }

    @Override
    public List<Evento> findAll() {
        List<EventoEntity> entities = eventoRepository.findAll();
        return entities.stream()
                .map(EventoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        eventoRepository.deleteById(id);
    }
}
