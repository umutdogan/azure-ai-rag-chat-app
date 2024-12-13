package com.umutdogan.ai.azure.ragchatapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Value("${azure.ai.endpoint}")
    private String azureAiEndpoint;

    @Value("${azure.ai.apiKey}")
    private String azureAiApiKey;

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String, String> request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(azureAiApiKey);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("query", request.get("question"));

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                azureAiEndpoint,
                HttpMethod.POST,
                entity,
                Map.class
            );
            Map<String, Object> responseBody = response.getBody();
            if (responseBody != null && responseBody.containsKey("output")) {
                return ResponseEntity.ok(responseBody.get("output").toString());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Invalid response from Azure AI");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
