package com.security.securityrest.users.entity;

import com.security.securityrest.authority.entity.Authority;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "login")
    private String login;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_authorities",
        joinColumns = @JoinColumn(name = "users_login"),
        inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private List<Authority> rolesList;

    public User(String login, String firstName, String password) {
        this.login = login;
        this.firstName = firstName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
            "login='" + login + '\'' +
            ", firstName='" + firstName + '\'' +
            ", password='" + password + '\'' +
            ", rolesList=" + rolesList +
            '}';
    }
}
