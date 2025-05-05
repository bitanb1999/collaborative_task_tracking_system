package com.example.tasktracker.service;

import com.example.tasktracker.model.Team;
import com.example.tasktracker.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public void addMember(Long teamId, Long userId) {
        // Simplified: Implement member addition logic
    }

    public void assignTask(Long teamId, Long taskId) {
        // Simplified: Implement task assignment logic
    }
}