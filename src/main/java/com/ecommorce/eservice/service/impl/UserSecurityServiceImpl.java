package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.dto.user.UserLoginDto;
import com.ecommorce.eservice.exception.IllegalAuthenticationException;
import com.ecommorce.eservice.model.Role;
import com.ecommorce.eservice.model.User;
import com.ecommorce.eservice.repository.RoleRepository;
import com.ecommorce.eservice.repository.UserRepository;
import com.ecommorce.eservice.security.JwtTokenProvider;
import com.ecommorce.eservice.service.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityServiceImpl implements UserSecurityService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    public String signin(UserLoginDto userLoginDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDto.getUsername(), userLoginDto.getPassword()));
            Optional<User> user = userRepository.findByUsername(userLoginDto.getUsername());
            List<Role> roles = null;
            if(user.isPresent()) roles = user.get().getRoles();
            return jwtTokenProvider.createToken(userLoginDto.getUsername(), roles);
        } catch (AuthenticationException e) {
            throw new IllegalAuthenticationException("Provided username/password invalid", HttpStatus.BAD_REQUEST);
        }
    }
    public Map<User, String> signupEncoding(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList(roleRepository.getById(2L)));
        return Collections.singletonMap(user, jwtTokenProvider.createToken(user.getUsername(), user.getRoles()));
    }

}
