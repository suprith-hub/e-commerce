package org.example.ecommerce.service.impl;

import org.example.ecommerce.exception.UserException;
import org.example.ecommerce.repository.UserRepository;
import org.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerUserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UserException {
        org.example.ecommerce.model.User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Username not found with email " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public org.example.ecommerce.model.User findUserById(Long id) throws UserException {
        return null;
    }

    @Override
    public org.example.ecommerce.model.User findUserProfileByJwt(String jwt) throws UserException {
        return null;
    }


}
