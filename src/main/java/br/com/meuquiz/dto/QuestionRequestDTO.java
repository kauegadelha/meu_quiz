package br.com.meuquiz.dto;

public class QuestionRequestDTO {

    private String text;
    private boolean response;

    public QuestionRequestDTO() {
    }

    public QuestionRequestDTO(String text, boolean response) {
        this.text = text;
        this.response = response;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}

