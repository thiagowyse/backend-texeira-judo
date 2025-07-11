package com.projetojudo.judotexeira.core.dtos.request;

import java.time.LocalDateTime;

public record EventoRequest (
    Long idEvento,
    String titulo,
    String descricao,
    LocalDateTime dataInicio,
    LocalDateTime dataFim,
    String local
) { }
