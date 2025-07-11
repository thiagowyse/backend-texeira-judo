package com.projetojudo.judotexeira.core.dtos.response;
import java.time.LocalDateTime;

public record PostBlogResponse(
        Long idPost,
        String titulo,
        String conteudo,
        UsuarioRegisterResponse usuario,
        LocalDateTime dataPublicacao
) { }
