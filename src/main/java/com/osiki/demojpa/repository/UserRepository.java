package com.osiki.demojpa.repository;

import com.osiki.demojpa.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
