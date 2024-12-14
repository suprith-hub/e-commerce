package org.example.ecommerce.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.ecommerce.config.JwtProvider;
import org.example.ecommerce.exception.UserException;
import org.example.ecommerce.model.User;
import org.example.ecommerce.repository.UserRepository;
import org.example.ecommerce.request.LoginRequest;
import org.example.ecommerce.response.AuthResponse;
import org.example.ecommerce.service.impl.CustomerUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    UserRepository userRepository;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    PasswordEncoder passwordEncoder;
    CustomerUserServiceImpl customerUserService;

    @Autowired
    public AuthController(UserRepository userRepository, CustomerUserServiceImpl customerUserService) {
        this.userRepository = userRepository;
        this.customerUserService = customerUserService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {

        // Check if user exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserException("Email already exists");
        }

        // encode before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        // get the Athentication and save the Authentication
        Authentication auth = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());

        // for loggin in the user, so that the appconfig knows and it allows teh requests
        SecurityContextHolder.getContext().setAuthentication(auth);

        // generate token using that auth
        String token = jwtProvider.generateToken(auth);

        // return the token
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setMessage("Signup successful");
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    @JsonIgnore
    public ResponseEntity<AuthResponse> loginHandler(@RequestBody LoginRequest loginRequest) throws UserException {
        Authentication auth = authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        SecurityContextHolder.getContext().setAuthentication(auth);
        // generate token using that auth
        String token = jwtProvider.generateToken(auth);

        // return the token
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setMessage("Signin successful");
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    }

    private Authentication authenticate(String username, String password) throws UserException {
        UserDetails user = customerUserService.loadUserByUsername(username);

        if(user == null){
            throw new UserException("User not found");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Wrong password");
        }
        return new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
    }
}
