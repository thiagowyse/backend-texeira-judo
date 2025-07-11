package com.projetojudo.judotexeira.infrastructure.presentation;

import com.projetojudo.judotexeira.core.dtos.request.PostBlogRequest;
import com.projetojudo.judotexeira.core.dtos.response.PostBlogResponse;
import com.projetojudo.judotexeira.core.entities.PostBlog;
import com.projetojudo.judotexeira.core.usecases.PostBlogUseCase;
import com.projetojudo.judotexeira.infrastructure.util.ResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostBlogController {

    private final PostBlogUseCase postBlogUseCase;

    @PostMapping
    public ResponseEntity<?> criarPost(@RequestBody PostBlogRequest postBlogRequest) {
        PostBlogResponse postSalvo = postBlogUseCase.salvar(postBlogRequest);
        return ResponseEntity.ok(new ResponseController<>("Post criado com sucesso", postSalvo).getResponseMessage());
    }

    @GetMapping
    public ResponseEntity<?> listarPosts() {
        List<PostBlogResponse> posts = postBlogUseCase.findAll();
        return ResponseEntity.ok(new ResponseController<>("Lista de posts", posts).getResponseMessage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPost(@PathVariable Long id) {
        postBlogUseCase.deletar(id);
        return ResponseEntity.ok(new ResponseController<>("Post deletado com sucesso", null).getResponseMessage());
    }
}
