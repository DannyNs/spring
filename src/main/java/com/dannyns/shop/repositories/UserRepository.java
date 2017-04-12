package com.dannyns.shop.repositories;

import com.dannyns.shop.entities.administration.User;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
