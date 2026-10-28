import java.util.List;
import java.util.Scanner;

public class Quiz {
    private String name;
    private List<Question> questions;
    private int points = 0;
    private char response;

    public Quiz(String name, List<Question> questions){
        this.name = name;
        this.questions = questions;
    }
    public String getName(){
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void start(Scanner scanner){

        for (Question q: questions) {
            System.out.println(q.getText());

            String r;
            do {
                System.out.println("\nResponda 'V' ou 'F': ");
                r = scanner.nextLine().trim().toUpperCase();
            } while (!r.equals("V") && !r.equals("F"));

            response = r.charAt(0);

            if ((response == 'V') == q.isResponse()) {
                points++;
            }
        }
        int result = calculateResult();
        System.out.println("\nResultado: Você acertou %d%% do quiz!".formatted(result));

    }

    public int calculateResult(){
        int correctPercentage = (points * 100) / questions.size();
        points = 0;
        return correctPercentage;
    }

    // Sobrecarga utilizada para testar o cálculo da porcentagem sem alterar o atributo points
    public int calculateResult(int points) {
        return (points * 100) / questions.size();
    }

}