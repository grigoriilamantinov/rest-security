package com.security.securityrest.authority.dto;

import com.security.securityrest.authority.entity.Authority;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class AuthorityWithoutUser {
    private String role;

    public static AuthorityWithoutUser of(final Authority authority) {
        final AuthorityWithoutUser authorityWithoutUser = new AuthorityWithoutUser();
        authorityWithoutUser.setRole(authority.getRole());
        return authorityWithoutUser;
    }
}
