package com.task.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.management.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
