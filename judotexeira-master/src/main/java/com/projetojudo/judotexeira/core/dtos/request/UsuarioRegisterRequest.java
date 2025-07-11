package com.projetojudo.judotexeira.core.dtos.request;

public record UsuarioRegisterRequest(
        String nome,
        String email,
        String senha
) {
}
