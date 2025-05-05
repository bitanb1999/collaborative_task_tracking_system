package com.example.tasktracker.controller;

import com.example.tasktracker.model.Team;
import com.example.tasktracker.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team team) {
        return ResponseEntity.ok(teamService.createTeam(team));
    }

    @PostMapping("/{id}/members")
    public ResponseEntity<Void> addMember(@PathVariable Long id, @RequestBody Long userId) {
        teamService.addMember(id, userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<Void> assignTask(@PathVariable Long id, @RequestBody Long taskId) {
        teamService.assignTask(id, taskId);
        return ResponseEntity.ok().build();
    }
}
