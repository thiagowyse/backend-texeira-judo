package com.projetojudo.judotexeira.infrastructure.mapper;

import com.projetojudo.judotexeira.core.dtos.request.UsuarioRegisterRequest;
import com.projetojudo.judotexeira.core.dtos.response.UsuarioLoginResponse;
import com.projetojudo.judotexeira.core.entities.Usuario;
import com.projetojudo.judotexeira.core.dtos.response.UsuarioRegisterResponse;

public class UsuarioDtoMapper {

    // UsuarioRequest -> Usuario (domain)
    public static Usuario toDomain(UsuarioRegisterRequest dto) {
        if (dto == null) {
            return null;
        }

        return new Usuario(
                null,               // idUsuario ainda não existe no request
                dto.nome(),
                dto.email(),
                dto.senha(),
                "viewer"            // padrão role inicial, pode alterar se quiser
        );
    }

    // Usuario (domain) -> UsuarioRequest (não é comum, mas aqui só pra exemplo)
    public static UsuarioRegisterRequest toRequest(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        return new UsuarioRegisterRequest(
                usuario.nome(),
                usuario.email(),
                usuario.senha()
        );
    }

    public static UsuarioLoginResponse toLoginResponse(String token) {
        return new UsuarioLoginResponse(token);
    }

    public static UsuarioRegisterResponse toRegisterResponse(Usuario usuario) {
        return new UsuarioRegisterResponse(
                usuario.idUsuario(),
                usuario.nome(),
                usuario.email()
        );
    }
}
