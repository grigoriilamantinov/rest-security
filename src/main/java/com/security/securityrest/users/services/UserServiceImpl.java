package com.security.securityrest.users.services;

import com.security.securityrest.users.dao.UserRepository;

import com.security.securityrest.users.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public UserEntity getById(int id) {
        return null;
    }

    @Override
    public List<UserEntity> getAll() {
        System.out.println();
        var result = userRepository.findAll();
        return result;
    }

    @Override
    public void save(UserEntity user) {

    }

    @Override
    public UserEntity getById(String id) {
        System.out.println();
        UserEntity result = userRepository.findById(id).orElseThrow();
        return result;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(int id) {

    }
}
