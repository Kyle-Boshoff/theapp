package com.teamConfiguration.teamConfiguration.users.Repository;

import com.teamConfiguration.teamConfiguration.users.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<user, Integer> {

    Optional<user> findById(Integer id);

    List<user> findByEmailAndPassword(String email, String password);
}
