package com.kirara.docker_test.websocket;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kirara.docker_test.entities.Employee;
import com.kirara.docker_test.services.EmployeeService;

@Component
public class EmployeeWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private EmployeeService employeeService;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sendEmployeeData(session);
    }

    private void sendEmployeeData(WebSocketSession session) {
        executorService.submit(() -> {
            try {
                List<Employee> employees = employeeService.getAllEmployees(); // Replace with your async method if
                                                                              // needed
                String message = convertToJson(employees); // Convert employees list to JSON
                session.sendMessage(new org.springframework.web.socket.TextMessage(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private String convertToJson(List<Employee> employees) throws JsonProcessingException {
        return new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(employees);
    }

}
