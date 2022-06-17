package com.security.securityrest.authority.entity;

import com.security.securityrest.users.entity.User;
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
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private String role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_authorities",
        joinColumns = @JoinColumn(name = "roles_id"),
        inverseJoinColumns = @JoinColumn(name = "users_login"))
    private List<User> usersList;

    public Authority(int id, String role) {
        this.id = id;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Authority{" +
            "id=" + id +
            ", role='" + role + '\'' +
            ", usersList=" + usersList +
            '}';
    }
}
