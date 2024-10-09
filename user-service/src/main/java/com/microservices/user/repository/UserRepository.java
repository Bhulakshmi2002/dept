package com.microservices.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.user.entity.UserDone;

@Repository
public interface UserRepository extends JpaRepository<UserDone, Long>{

	UserDone findByUserId(Long userId);

}
