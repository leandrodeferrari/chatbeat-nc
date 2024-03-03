package com.c1632mjava.c1632mjava.Application.Validations;

import com.c1632mjava.c1632mjava.Domain.Dtos.AuthResponse;
import com.c1632mjava.c1632mjava.Domain.Dtos.LoginDTO;
import com.c1632mjava.c1632mjava.Domain.Dtos.User.UserCreateDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.User.UserReadDto;
import com.c1632mjava.c1632mjava.Domain.Entities.User;
import com.c1632mjava.c1632mjava.Domain.Repositories.UserRepository;
import com.c1632mjava.c1632mjava.Infrastructure.Errors.UserNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Esta clase debe pasarse a la capa de Domain, sección servicios
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
  
    public AuthResponse login(LoginDTO data) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.email(),
                data.password()));
        User user = userRepository.findByEmail(data.email())
                .orElseThrow( () -> new UserNotFoundException(data.email()));
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .userId(user.getUserId())
                .build();
    }

    @Transactional
    public AuthResponse register(UserCreateDto data) {

        User user = User.builder()
                .email(data.email())
                .password(passwordEncoder.encode(data.password()))
                .name(data.name())
                .birthdate(data.birthdate())
                .photo(data.photo())
                .gender(data.gender())
                .pronouns(data.pronouns())
                .description(data.description())
                .active(true)
                .build();
        user = userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .userId(user.getUserId())
                .build();
    }

}
