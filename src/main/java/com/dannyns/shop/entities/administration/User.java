package com.dannyns.shop.entities.administration;

import com.dannyns.shop.entities.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity
public class User extends BaseEntity {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @ManyToMany
    private Set<Role> roles;

}
