package com.security.securityrest.users.endpoints;

import com.security.securityrest.users.entity.user.AddUserRequest;
import com.security.securityrest.users.entity.user.AddUserResponse;
import com.security.securityrest.users.entity.user.DeleteUserRequest;
import com.security.securityrest.users.entity.user.DeleteUserResponse;
import com.security.securityrest.users.entity.user.GetAllUserResponse;
import com.security.securityrest.users.entity.user.GetUserByLoginRequest;
import com.security.securityrest.users.entity.user.GetUserByLoginResponse;
import com.security.securityrest.users.entity.user.UpdateUserRequest;
import com.security.securityrest.users.entity.user.UpdateUserResponse;
import com.security.securityrest.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.stream.Collectors;


@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://user.entity.users.securityrest.security.com";

    private UserService userService;

    public UserEndpoint(
        @Autowired UserService userService
    ) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByLoginRequest")
    @ResponsePayload
    public GetUserByLoginResponse getUserById (@RequestPayload GetUserByLoginRequest request) {
        GetUserByLoginResponse response = new GetUserByLoginResponse();
        response.setUser(userService.getById(request.getLogin()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUserRequest")
    @ResponsePayload
    public GetAllUserResponse getAllUser() {
        GetAllUserResponse response = new GetAllUserResponse();
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUserById(@RequestPayload DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        userService.delete(request.getLogin());
        response.setMessage("Deleted");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload AddUserRequest request) {
        AddUserResponse response = new AddUserResponse();
        return response;
    }
}
