package com.projetojudo.judotexeira.core.usecases;

import com.projetojudo.judotexeira.core.dtos.request.LoginRequest;
import com.projetojudo.judotexeira.core.dtos.request.UsuarioRegisterRequest;
import com.projetojudo.judotexeira.core.entities.Usuario;

public interface AuthUseCase {

    Usuario register(UsuarioRegisterRequest usuario);
    String login(LoginRequest usuario);

}
