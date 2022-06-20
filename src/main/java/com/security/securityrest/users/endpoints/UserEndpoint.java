package com.security.securityrest.users.endpoints;

import com.security.securityrest.users.dto.UserTransformer;
import com.security.securityrest.users.entity.UserEntity;
import com.security.securityrest.users.entity.user.GetUserRequest;
import com.security.securityrest.users.entity.user.GetUserResponse;
import com.security.securityrest.users.entity.user.User;
import com.security.securityrest.users.entity.user.UserFindAllRequest;
import com.security.securityrest.users.entity.user.UserFindAllResponse;
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setUser(userService.getById(request.getLogin()));
        return getUserResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "userFindAllRequest")
    @ResponsePayload
    public UserFindAllResponse getAllUser(@RequestPayload UserFindAllRequest request) {
        UserFindAllResponse userFindAllResponse = new UserFindAllResponse();
        return userFindAllResponse;
    }
}
