package com.security.securityrest.users.services;

import com.security.securityrest.users.dao.UserRepository;
import com.security.securityrest.users.dto.UserWithNameDTO;
import com.security.securityrest.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(
        @Autowired UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserWithNameDTO> getAllUserWithName() {
        return userRepository.findAll().stream()
            .map(user -> UserWithNameDTO.of(user))
            .collect(Collectors.toList());
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
