package com.security.securityrest.authority.services;

import com.security.securityrest.authority.dto.AuthorityWithoutUser;

import java.util.List;

public interface AuthorityService {
    List<AuthorityWithoutUser> getAll();

    void save(AuthorityWithoutUser auth);

    AuthorityWithoutUser getById(int id);

    void delete(int id);
}
