package com.mongo.demo.controller;


import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthCheckController {

    private final MongoClient mongoClient;

    public HealthCheckController(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @GetMapping("/db")
    public ResponseEntity<Map<String, Object>> checkDb() {
        try {
            Document result = mongoClient
                    .getDatabase("admin")
                    .runCommand(new Document("ping", 1));


            return ResponseEntity.ok(Map.of(
                    "status", "UP",
                    "database", "MongoDB",
                    "ping", result.get("ok").toString()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(503).body(Map.of(
                    "status", "DOWN",
                    "error", e.getMessage()
            ));
        }
    }
}
