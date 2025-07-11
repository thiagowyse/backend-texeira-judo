package com.projetojudo.judotexeira.infrastructure.gateway;

import com.projetojudo.judotexeira.core.dtos.request.LoginRequest;
import com.projetojudo.judotexeira.core.entities.Usuario;
import com.projetojudo.judotexeira.core.enums.Role;
import com.projetojudo.judotexeira.core.dtos.request.UsuarioRegisterRequest;
import com.projetojudo.judotexeira.infrastructure.exception.UsernameOrPasswordInvalidException;
import com.projetojudo.judotexeira.core.gateway.AuthGateway;
import com.projetojudo.judotexeira.infrastructure.config.TokenService;
import com.projetojudo.judotexeira.infrastructure.mapper.UsuarioEntityMapper;
import com.projetojudo.judotexeira.infrastructure.persistence.entity.UsuarioEntity;
import com.projetojudo.judotexeira.infrastructure.persistence.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthUsuarioGatewayImpl implements AuthGateway {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Usuario register(UsuarioRegisterRequest userRequest) {
        Usuario newUser = new Usuario(
                null,
                userRequest.nome(),
                userRequest.email(),
                passwordEncoder.encode(userRequest.senha()),
                Role.ADMIN.asString()
        );

        UsuarioEntity userSaved = usuarioRepository.save(UsuarioEntityMapper.toEntity(newUser));

        Usuario userDomain = UsuarioEntityMapper.toDomain(userSaved);
        return userDomain;
    }

    @Override
    public String login(LoginRequest userLoginRequest) {
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(userLoginRequest.email(), userLoginRequest.senha());
            Authentication authenticate = authenticationManager.authenticate(userAndPass);

            UsuarioEntity user = (UsuarioEntity) authenticate.getPrincipal();

            String token = tokenService.generateToken(user);

            return token;
        } catch (BadCredentialsException e) {
            throw new UsernameOrPasswordInvalidException("Usuário ou senha inválidos.");
        }
    }

    @Override
    public void logout(Usuario usuario) {

    }

}
