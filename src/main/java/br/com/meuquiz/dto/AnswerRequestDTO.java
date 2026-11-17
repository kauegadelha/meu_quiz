package br.com.meuquiz.dto;

import java.util.List;

public class AnswerRequestDTO {

    private List<Boolean> answers;

    public AnswerRequestDTO() {}

    public List<Boolean> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Boolean> answers) {
        this.answers = answers;
    }
}
