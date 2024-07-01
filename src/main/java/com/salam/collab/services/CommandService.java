package com.salam.collab.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CommandService {
    @Value("${sudo-password}")
    private String sudoPassword;
    public String executeCommand(String command) throws IOException {
        // If the system is Linux
        var os = System.getProperty("os.name");

        if (os.toLowerCase().contains("nux")) {
            // If the command is sudo
            if (command.toLowerCase().startsWith("sudo ")) {
                ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", "echo '" + sudoPassword + "' | sudo -S " + command);
                processBuilder.redirectErrorStream(true);
                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder output = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }

                return output.toString();
            } else {
                Process process = Runtime.getRuntime().exec(command);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder output = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }

                return output.toString();
            }
        } else {
            // If the OS is other than linux
            return "Not running on linux system, will handle this soon";
        }



    }
}
