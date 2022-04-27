package com.example.todo.service;

import com.example.todo.entity.UserEntity;
import com.example.todo.exception.UserAlreadyExistException;
import com.example.todo.exception.UserNotFoundException;
import com.example.todo.model.User;
import com.example.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw  new UserAlreadyExistException("Username is already taken motherfucker");
        }
        return userRepository.save(user);
    }

    public User getOneUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();

        if ( user == null) {
            throw new UserNotFoundException("There is no user like this, motherfucker");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);

        return id;
    }
}
