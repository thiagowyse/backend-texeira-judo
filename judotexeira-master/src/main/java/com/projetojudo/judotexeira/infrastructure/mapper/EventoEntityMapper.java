package com.projetojudo.judotexeira.infrastructure.mapper;

import com.projetojudo.judotexeira.core.entities.Evento;
import com.projetojudo.judotexeira.infrastructure.persistence.entity.EventoEntity;

public class EventoEntityMapper {

    public static EventoEntity toEntity(Evento evento){
        if(evento == null){
            return null;
        }

        return EventoEntity.builder()
                .idEvento(evento.idEvento())
                .titulo(evento.titulo())
                .descricao(evento.descricao())
                .dataInicio(evento.dataInicio())
                .dataFim(evento.dataFim())
                .local(evento.local())
                .build();
    }

    public static Evento toDomain(EventoEntity entity){
        if(entity == null){
            return null;
        }

        return new Evento(
                entity.getIdEvento(),
                entity.getTitulo(),
                entity.getDescricao(),
                entity.getDataInicio(),
                entity.getDataFim(),
                entity.getLocal()
        );
    }
}
