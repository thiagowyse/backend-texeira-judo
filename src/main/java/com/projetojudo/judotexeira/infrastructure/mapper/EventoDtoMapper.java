package com.projetojudo.judotexeira.infrastructure.mapper;

import com.projetojudo.judotexeira.core.dtos.request.EventoRequest;
import com.projetojudo.judotexeira.core.dtos.response.EventoResponse;
import com.projetojudo.judotexeira.core.entities.Evento;

public class EventoDtoMapper {

    public static Evento toDomain(EventoRequest dto){
        if(dto == null){
            return  null;
        }

        return new Evento(
                dto.idEvento(),
                dto.titulo(),
                dto.descricao(),
                dto.dataInicio(),
                dto.dataFim(),
                dto.local()
        );

        }

    public static EventoRequest toRequest(Evento evento) {

        if(evento == null){
            return null;
        }

        return new EventoRequest(
                evento.idEvento(),
                evento.titulo(),
                evento.descricao(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.local()
        );
    }

    public static EventoResponse toRegisterResponse(Evento evento){
        return new EventoResponse(
                evento.idEvento(),
                evento.titulo(),
                evento.descricao(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.local()
        );
    }
}
