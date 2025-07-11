package com.projetojudo.judotexeira.core.dtos.request;
import java.time.LocalDateTime;

public record PostBlogRequest(
       Long idPost,
       String titulo,
       String conteudo,
       Long idAutor,
       LocalDateTime dataPublicacao
) {}
