package com.security.securityrest.authority.services;

import com.security.securityrest.common.SecurityRestCRUD;
import com.security.securityrest.authority.dto.AuthorityWithoutUser;

import java.util.List;

public interface AuthorityService extends SecurityRestCRUD<AuthorityWithoutUser> {
    @Override
    List<AuthorityWithoutUser> getAll();

    @Override
    void save(AuthorityWithoutUser auth);

    @Override
    AuthorityWithoutUser getById(int id);

    @Override
    void delete(int id);
}
