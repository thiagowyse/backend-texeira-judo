package com.projetojudo.judotexeira.infrastructure.gateway;

import com.projetojudo.judotexeira.core.dtos.request.PostBlogRequest;
import com.projetojudo.judotexeira.core.dtos.response.PostBlogResponse;
import com.projetojudo.judotexeira.core.gateway.PostBlogGateway;
import com.projetojudo.judotexeira.infrastructure.config.DataHoraUtils;
import com.projetojudo.judotexeira.infrastructure.config.JWTUserData;
import com.projetojudo.judotexeira.infrastructure.mapper.PostBlogDtoMapper;
import com.projetojudo.judotexeira.infrastructure.mapper.PostBlogEntityMapper;
import com.projetojudo.judotexeira.infrastructure.persistence.entity.PostBlogEntity;
import com.projetojudo.judotexeira.infrastructure.persistence.entity.UsuarioEntity;
import com.projetojudo.judotexeira.infrastructure.persistence.repository.PostBlogRepository;
import com.projetojudo.judotexeira.infrastructure.persistence.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PostBlogGatewayImpl implements PostBlogGateway {

    private final PostBlogRepository postBlogRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public PostBlogResponse salvar(PostBlogRequest postBlogRequest) {
        JWTUserData userData = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long idUsuarioLogado = userData.userId();

        UsuarioEntity autorPersistido = usuarioRepository.findById(idUsuarioLogado)
                .orElseThrow(() -> new RuntimeException("Usuário logado não encontrado no banco"));

        PostBlogEntity postEntity = PostBlogEntity.builder()
                .idPost(postBlogRequest.idPost())
                .titulo(postBlogRequest.titulo())
                .conteudo(postBlogRequest.conteudo())
                .autor(autorPersistido)
                .dataPublicacao(DataHoraUtils.obterDataHoraLocal())
                .build();

        PostBlogEntity saved = postBlogRepository.save(postEntity);
        return PostBlogDtoMapper.toRegisterResponse(PostBlogEntityMapper.toDomain(saved));
    }

    @Override
    public List<PostBlogResponse> findAll() {
        return postBlogRepository.findAll().stream()
                .map(PostBlogEntityMapper::toDomain)
                .map(PostBlogDtoMapper::toRegisterResponse)
                .toList();
    }


    @Override
    public void deletar(Long id) {
        postBlogRepository.deleteById(id);
    }
}
