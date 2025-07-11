package com.projetojudo.judotexeira.infrastructure.config;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DataHoraUtils {

    private static final ZoneId ZONA_PADRAO = ZoneId.of("America/Sao_Paulo");

    public static LocalDateTime obterDataHoraLocal() {
        return LocalDateTime.now(ZONA_PADRAO);
    }
}
