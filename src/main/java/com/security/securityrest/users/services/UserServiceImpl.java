package com.security.securityrest.users.services;

import com.security.securityrest.common.AuthoritiesParser;
import com.security.securityrest.common.ValidationControl;
import com.security.securityrest.users.dao.UserRepository;

import com.security.securityrest.users.dto.UserListTransformer;
import com.security.securityrest.users.dto.UserTransformer;
import com.security.securityrest.users.entity.UserEntity;
import com.security.securityrest.users.entity.user.AddUserRequest;
import com.security.securityrest.users.entity.user.AddUserResponse;
import com.security.securityrest.users.entity.user.DeleteUserResponse;
import com.security.securityrest.users.entity.user.GetAllUserResponse;
import com.security.securityrest.users.entity.user.GetUserByLoginResponse;
import com.security.securityrest.users.entity.user.UpdateUserRequest;
import com.security.securityrest.users.entity.user.UpdateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final AuthoritiesParser authoritiesParser;

    public UserServiceImpl(
        @Autowired UserRepository userRepository,
        @Autowired AuthoritiesParser authoritiesParser
    ) {
        this.userRepository = userRepository;
        this.authoritiesParser = authoritiesParser;
    }

    @Override
    public GetAllUserResponse getAll() {
        GetAllUserResponse response = new GetAllUserResponse();
        response.setUserList(UserListTransformer.of(userRepository.findAll()));
        return response;
    }

    @Override
    public AddUserResponse save(final AddUserRequest request) {
        final var login = request.getLogin();
        boolean isValid = false;

        if (!userRepository.existsById(login)) {
            UserEntity userEntity = new UserEntity(
                login,
                request.getName(),
                request.getPassword(),
                authoritiesParser.parsToList(request.getAuthority())
            );
            isValid = ValidationControl.checkInput(userEntity);
            if (isValid) {
                userRepository.save(userEntity);
            }
        }

        AddUserResponse response = new AddUserResponse();
        response.setSuccess(isValid);
        return response;
    }

    @Override
    public UpdateUserResponse update(final UpdateUserRequest request) {
        final var login = request.getLogin();
        boolean isValid = false;

        if (userRepository.existsById(login)) {
            UserEntity userEntity = new UserEntity(
                login,
                request.getName(),
                request.getPassword(),
                authoritiesParser.parsToList(request.getAuthority())
            );
            isValid = ValidationControl.checkInput(userEntity);
            if (isValid) {
                userRepository.save(userEntity);
            }
        }

        UpdateUserResponse response = new UpdateUserResponse();
        response.setSuccess(isValid);
        return response;
    }

    @Override
    public GetUserByLoginResponse getByLogin(String id) {
        GetUserByLoginResponse response = new GetUserByLoginResponse();
        final var userEntity = userRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException(
                    String.format("No element with id = %s in authority database", id)
                )
            );

        response.setUser(UserTransformer.of(userEntity));
        return response;
    }

    @Override
    public DeleteUserResponse deleteByLogin(String login) {
        DeleteUserResponse response = new DeleteUserResponse();
        if (userRepository.existsById(login)) {
            userRepository.delete(userRepository.findById(login).orElseThrow());
            response.setMessage(String.format("User with login: %s was deleted successfully", login));
        } else {
            response.setMessage(String.format("Deletion failed, user with login: %s is not in the database.", login));
        }
        return response;
    }
}
