package com.projetojudo.judotexeira.infrastructure.mapper;

import com.projetojudo.judotexeira.core.dtos.request.PostBlogRequest;
import com.projetojudo.judotexeira.core.dtos.response.PostBlogResponse;
import com.projetojudo.judotexeira.core.dtos.response.UsuarioRegisterResponse;
import com.projetojudo.judotexeira.core.entities.PostBlog;
import com.projetojudo.judotexeira.core.entities.Usuario;

public class PostBlogDtoMapper {

    public static PostBlog toDomain(PostBlogRequest dto){
        if(dto == null){
            return null;
        }

        Usuario autor = null;
        if(dto.idAutor() != null){
            autor = Usuario.withId(dto.idAutor());
        }

        return new PostBlog(
                dto.idPost(),
                dto.titulo(),
                dto.conteudo(),
                autor,
                dto.dataPublicacao()
        );
    }




    public static PostBlogRequest toRequest(PostBlog postBlog){
        if(postBlog == null){
            return null;
        }

        return new PostBlogRequest(
                postBlog.idPost(),
                postBlog.titulo(),
                postBlog.conteudo(),
                postBlog.autor() != null ? postBlog.autor().idUsuario() : null,
                postBlog.dataPublicacao()
        );
    }

    public static PostBlogResponse toRegisterResponse(PostBlog postBlog) {
        if (postBlog == null) {
            return null;
        }

        UsuarioRegisterResponse autorResponse = null;
        if (postBlog.autor() != null) {
            autorResponse = UsuarioDtoMapper.toRegisterResponse(postBlog.autor());

        }

        return new PostBlogResponse(
                postBlog.idPost(),
                postBlog.titulo(),
                postBlog.conteudo(),
                autorResponse,
                postBlog.dataPublicacao()
        );
    }

}
