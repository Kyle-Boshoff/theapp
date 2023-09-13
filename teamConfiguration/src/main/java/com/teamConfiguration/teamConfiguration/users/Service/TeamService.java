package com.teamConfiguration.teamConfiguration.users.Service;

import com.teamConfiguration.teamConfiguration.users.Entity.Team;
import com.teamConfiguration.teamConfiguration.users.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService (TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public Team getTeams(){
        return teamRepository.findAll().get(0);
    }
}
