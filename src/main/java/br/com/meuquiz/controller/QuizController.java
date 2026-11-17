package br.com.meuquiz.controller;

import br.com.meuquiz.dto.QuestionResponseDTO;
import br.com.meuquiz.dto.QuizRequestDTO;
import br.com.meuquiz.dto.AnswerRequestDTO;
import br.com.meuquiz.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of(
                "status", "online",
                "message", "API do Meu Quiz funcionando!"
        );
    }


    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestBody QuizRequestDTO request) {
        quizService.createQuiz(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Quiz criado com sucesso!");
    }

    @GetMapping("/questions")
    public List<QuestionResponseDTO> getQuestions() {
        return quizService.getQuestions();
    }

    @PostMapping("/answer")
    public Map<String, Object> answerQuiz(@RequestBody AnswerRequestDTO request) {
        return quizService.answerQuiz(request.getAnswers());
    }

}

