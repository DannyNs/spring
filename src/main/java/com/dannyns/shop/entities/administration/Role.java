package com.dannyns.shop.entities.administration;

import com.dannyns.shop.entities.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity
public class Role extends BaseEntity {

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
