package br.com.meuquiz.dto;

import java.util.List;

public class QuizRequestDTO {

    private String name;
    private List<QuestionRequestDTO> questions;

    public QuizRequestDTO() {
    }

    public QuizRequestDTO(String name, List<QuestionRequestDTO> questions) {
        this.name = name;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionRequestDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionRequestDTO> questions) {
        this.questions = questions;
    }
}

