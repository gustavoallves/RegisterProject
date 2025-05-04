package com.example.registerspring.users;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> listUser() {
        return userRepository.findAll();
    }

    public UserModel findById(Long id) {
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.orElse(null);
    }

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

}
