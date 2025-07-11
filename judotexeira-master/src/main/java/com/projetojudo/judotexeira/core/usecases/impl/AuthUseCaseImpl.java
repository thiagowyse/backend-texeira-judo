package com.projetojudo.judotexeira.core.usecases.impl;

import com.projetojudo.judotexeira.core.dtos.request.LoginRequest;
import com.projetojudo.judotexeira.core.dtos.request.UsuarioRegisterRequest;
import com.projetojudo.judotexeira.core.entities.Usuario;
import com.projetojudo.judotexeira.core.gateway.AuthGateway;
import com.projetojudo.judotexeira.core.usecases.AuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthUseCaseImpl implements AuthUseCase {
    private final AuthGateway authGateway;




    @Override
    public String login(LoginRequest userLoginRequest) {
        return authGateway.login(userLoginRequest);
    }

    @Override
    public Usuario register(UsuarioRegisterRequest userRequest) {
        return authGateway.register(userRequest);
    }
}
