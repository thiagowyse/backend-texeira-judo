package com.projetojudo.judotexeira.core.gateway;

import com.projetojudo.judotexeira.core.dtos.request.PostBlogRequest;
import com.projetojudo.judotexeira.core.dtos.response.PostBlogResponse;

import java.util.List;

public interface PostBlogGateway {
    PostBlogResponse salvar(PostBlogRequest postBlog);
    List<PostBlogResponse> findAll();
    void deletar(Long id);
}
