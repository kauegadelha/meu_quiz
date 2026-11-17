package br.com.meuquiz.dto;

public class QuestionResponseDTO {

    private int id;
    private String text;

    public QuestionResponseDTO(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}

