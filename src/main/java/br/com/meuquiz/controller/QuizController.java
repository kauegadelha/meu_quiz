package br.com.meuquiz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of(
                "status", "online",
                "message", "API do Meu Quiz funcionando!"
        );
    }
}

