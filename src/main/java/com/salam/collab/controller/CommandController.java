package com.salam.collab.controller;

import com.salam.collab.services.CommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commands")
public class CommandController {

    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping("/execute")
    public ResponseEntity<String> executeCommand(@RequestBody String command) {
        try {
            String output = commandService.executeCommand(command);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error executing command: " + e.getMessage());
        }
    }
}