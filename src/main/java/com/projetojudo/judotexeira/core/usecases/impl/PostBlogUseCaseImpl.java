package com.projetojudo.judotexeira.core.usecases.impl;

import com.projetojudo.judotexeira.core.dtos.request.PostBlogRequest;
import com.projetojudo.judotexeira.core.dtos.response.PostBlogResponse;
import com.projetojudo.judotexeira.core.entities.PostBlog;
import com.projetojudo.judotexeira.core.gateway.PostBlogGateway;
import com.projetojudo.judotexeira.core.usecases.PostBlogUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PostBlogUseCaseImpl implements PostBlogUseCase {

    private final PostBlogGateway postBlogGateway;



    @Override
    public PostBlogResponse salvar(PostBlogRequest postBlog) {
        return postBlogGateway.salvar(postBlog);
    }

    @Override
    public List<PostBlogResponse> findAll() {
        return postBlogGateway.findAll();
    }


    @Override
    public void deletar(Long id) {
        postBlogGateway.deletar(id);
    }
}
