package com.users.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.rest.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
