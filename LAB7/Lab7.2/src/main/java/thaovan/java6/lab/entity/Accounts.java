package thaovan.java6.lab.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@EqualsAndHashCode(exclude = {"roles"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts", schema = "dbo")
@Entity
public class Accounts {

    @Column(name = "email")
    private String email;

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "photo")
    private String photo;

    @ManyToMany
    @JoinTable(
            name = "authorities",
            joinColumns = {@JoinColumn(name = "account_username")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Roles> roles;
}
