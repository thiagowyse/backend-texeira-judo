package com.projetojudo.judotexeira.infrastructure.mapper;

import com.projetojudo.judotexeira.core.entities.PostBlog;
import com.projetojudo.judotexeira.infrastructure.persistence.entity.PostBlogEntity;
import org.springframework.stereotype.Component;

@Component
public class PostBlogEntityMapper {

    public static PostBlogEntity toEntity(PostBlog postBlog) {
        if (postBlog == null) {
            return null;
        }

        return PostBlogEntity.builder()
                .idPost(postBlog.idPost())
                .autor(UsuarioEntityMapper.toEntity(postBlog.autor()))
                .titulo(postBlog.titulo())
                .conteudo(postBlog.conteudo())
                .dataPublicacao(postBlog.dataPublicacao())
                .build();
    }

    public static PostBlog toDomain(PostBlogEntity entity){
        if(entity == null){
            return null;
        }

        return new PostBlog(
                entity.getIdPost(),
                entity.getTitulo(),
                entity.getConteudo(),
                UsuarioEntityMapper.toDomain(entity.getAutor()),
                entity.getDataPublicacao()
        );
    }
}

