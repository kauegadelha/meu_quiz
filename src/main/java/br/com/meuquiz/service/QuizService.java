package br.com.meuquiz.service;

import br.com.meuquiz.Quiz;
import br.com.meuquiz.Question;
import br.com.meuquiz.dto.QuizRequestDTO;
import br.com.meuquiz.dto.QuestionRequestDTO;
import br.com.meuquiz.dto.QuestionResponseDTO;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    private Quiz quiz;

    public Map<String, String> getStatus() {
        return Map.of(
                "status", "online",
                "message", "API do Meu Quiz funcionando!"
        );
    }


    public List<QuestionResponseDTO> getQuestions() {
        if (quiz == null) {
            throw new IllegalStateException("O quiz ainda não foi criado!");
        }

        return quiz.getQuestions().stream()
                .map(question -> new QuestionResponseDTO(
                        question.getId(),
                        question.getText()
                ))
                .toList();
    }

    public void createQuiz(QuizRequestDTO request) {

        if (quiz != null) {
            throw new IllegalStateException("O quiz já está criado!");
        }

        if (request.getName() == null || request.getName().isBlank()) {
            throw new IllegalArgumentException("O nome do quiz não pode ser vazio!");
        }

        if (request.getQuestions() == null || request.getQuestions().isEmpty()) {
            throw new IllegalArgumentException("O quiz precisa ter perguntas!");
        }

        List<Question> questionList = new ArrayList<>();

        for (int i = 0; i < request.getQuestions().size(); i++) {

            QuestionRequestDTO questionDTO = request.getQuestions().get(i);

            if (questionDTO.getText() == null || questionDTO.getText().isBlank()) {
                throw new IllegalArgumentException("O texto da pergunta não pode ser vazio!");
            }

            Question question = new Question(
                    i + 1,
                    questionDTO.getText(),
                    questionDTO.isResponse()
            );

            questionList.add(question);
        }

        quiz = new Quiz(request.getName(), questionList);
    }

    public Map<String, Object> answerQuiz(List<Boolean> answers) {
        if (quiz == null) {
            throw new IllegalStateException("O quiz ainda não foi criado!");
        }

        if (answers == null || answers.isEmpty()) {
            throw new IllegalArgumentException("As respostas não podem ser vazias!");
        }

        if (answers.size() != quiz.getQuestions().size()) {
            throw new IllegalArgumentException("Quantidade de respostas inválida!");
        }

        if (answers.contains(null)) {
            throw new IllegalArgumentException("As respostas não podem ser nulas!");
        }

        int correctAnswers = 0;

        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i) == quiz.getQuestions().get(i).isResponse()) {
                correctAnswers++;
            }
        }

        double result = quiz.calculateResult(correctAnswers);

        return Map.of(
                "correctAnswers", correctAnswers,
                "totalQuestions", quiz.getQuestions().size(),
                "score", result
        );
    }
}
