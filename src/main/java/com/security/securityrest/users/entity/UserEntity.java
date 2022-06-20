package com.security.securityrest.users.entity;

import com.security.securityrest.authority.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "login")
    private String login;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "password")
    private String password;

    @ManyToMany(
        fetch = FetchType.EAGER,
        cascade = {
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
        }
    )
    @JoinTable(
        name = "users_authorities",
        joinColumns = @JoinColumn(name = "users_login"),
        inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private List<Authority> rolesList;

    public UserEntity(String login, String firstName, String password) {
        this.login = login;
        this.firstName = firstName;
        this.password = password;
    }
}
