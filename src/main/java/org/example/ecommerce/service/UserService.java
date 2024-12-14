package org.example.ecommerce.service;

import org.example.ecommerce.exception.UserException;
import org.example.ecommerce.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    public UserDetails loadUserByUsername(String id) throws UserException;

    public User findUserById(Long id) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;
}
