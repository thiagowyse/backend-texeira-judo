package com.projetojudo.judotexeira.infrastructure.presentation;

import com.projetojudo.judotexeira.core.dtos.response.UsuarioLoginResponse;
import com.projetojudo.judotexeira.core.entities.Usuario;
import com.projetojudo.judotexeira.core.usecases.AuthUseCase;
import com.projetojudo.judotexeira.core.dtos.request.LoginRequest;
import com.projetojudo.judotexeira.core.dtos.request.UsuarioRegisterRequest;
import com.projetojudo.judotexeira.core.dtos.response.UsuarioRegisterResponse;
import com.projetojudo.judotexeira.infrastructure.mapper.UsuarioDtoMapper;
import com.projetojudo.judotexeira.infrastructure.util.ResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RequiredArgsConstructor
@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    private final AuthUseCase authUseCase;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@Validated @RequestBody UsuarioRegisterRequest userRequest) {
        Usuario registerUser = authUseCase.register(userRequest);

        ResponseController<UsuarioRegisterResponse> registerResponse = new ResponseController<>(
                "Usuário registrado com sucesso",
                UsuarioDtoMapper.toRegisterResponse(registerUser)
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse.getResponseMessage());
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@Validated @RequestBody LoginRequest userLoginRequest) {
        String token = authUseCase.login(userLoginRequest);

        ResponseController<UsuarioLoginResponse> registerResponse = new ResponseController<>(
                "Usuário logado com sucesso",
                new UsuarioLoginResponse(token)
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse.getResponseMessage());
    }

}
