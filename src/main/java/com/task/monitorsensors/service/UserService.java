package com.task.monitorsensors.service;

import com.task.monitorsensors.entity.UserEntity;
import com.task.monitorsensors.exception.ElementAlreadyExistsException;
import com.task.monitorsensors.repositopy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public UserEntity save(UserEntity userEntity) throws ElementAlreadyExistsException {
        try {
            return userRepository.save(userEntity);
        }
        catch (Exception exception) {
            throw new ElementAlreadyExistsException("User with such username already exists.");
        }
    }

    public UserEntity getByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }
}
