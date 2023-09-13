package com.teamConfiguration.teamConfiguration.users.Repository;

import com.teamConfiguration.teamConfiguration.users.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
