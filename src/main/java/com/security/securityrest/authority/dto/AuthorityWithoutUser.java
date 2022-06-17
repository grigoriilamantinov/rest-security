package com.security.securityrest.authority.dto;

import com.security.securityrest.authority.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorityWithoutUser {
    private String role;

    public static AuthorityWithoutUser of (final Authority authority) {
        final AuthorityWithoutUser authorityWithoutUser = new AuthorityWithoutUser();
        authorityWithoutUser.setRole(authority.getRole());
        return authorityWithoutUser;
    }
}
