package com.security.securityrest.users.services;

import com.security.securityrest.users.dao.UserRepository;

import com.security.securityrest.users.dto.UserTransformer;
import com.security.securityrest.users.entity.UserEntity;
import com.security.securityrest.users.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(
        @Autowired UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll().stream()
            .map(userEntity -> UserTransformer.of(userEntity))
            .collect(Collectors.toList());
    }

    @Override
    public void save(User user) {

    }


    @Override
    public User getById(String id) {
        return UserTransformer.of(userRepository.findById(id).orElseThrow());
    }

    @Override
    public void delete(String id) {

    }
}
