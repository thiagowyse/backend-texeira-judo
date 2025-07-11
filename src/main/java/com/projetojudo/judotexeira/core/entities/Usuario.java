package com.projetojudo.judotexeira.core.entities;

public record Usuario(
        Long idUsuario,
        String nome,
        String email,
        String senha,
        String role
) {
    public static Usuario withId(Long idUsuario) {
        return new Usuario(idUsuario, null, null, null, null);
    }
}