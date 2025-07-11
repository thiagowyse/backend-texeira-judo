package com.projetojudo.judotexeira.infrastructure.mapper;

import com.projetojudo.judotexeira.core.entities.Usuario;
import com.projetojudo.judotexeira.core.enums.Role;
import com.projetojudo.judotexeira.infrastructure.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityMapper {

    public static UsuarioEntity toEntity(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        return UsuarioEntity.builder()
                .idUsuario(usuario.idUsuario())
                .nome(usuario.nome())
                .email(usuario.email())
                .senha(usuario.senha())
                .role(Role.valueOf(usuario.role().toUpperCase()))
                .build();
    }

    public static Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Usuario(
                entity.getIdUsuario(),
                entity.getNome(),
                entity.getEmail(),
                entity.getSenha(),
                entity.getRole().name().toLowerCase()
        );
    }
}
