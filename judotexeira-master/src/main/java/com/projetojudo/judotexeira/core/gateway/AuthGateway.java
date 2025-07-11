package com.projetojudo.judotexeira.core.gateway;

import com.projetojudo.judotexeira.core.dtos.request.LoginRequest;
import com.projetojudo.judotexeira.core.dtos.request.UsuarioRegisterRequest;
import com.projetojudo.judotexeira.core.entities.Usuario;

public interface AuthGateway {

    String login(LoginRequest usuario);
    Usuario register(UsuarioRegisterRequest usuario);
    void logout(Usuario usuario);

}
