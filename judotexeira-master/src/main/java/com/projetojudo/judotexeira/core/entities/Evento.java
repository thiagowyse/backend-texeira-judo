package com.projetojudo.judotexeira.core.entities;

import java.time.LocalDateTime;

public record Evento (
        Long idEvento,
        String titulo,
        String descricao,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String local
){
}
