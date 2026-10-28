import java.util.List;
import java.util.Scanner;

public class Quiz {
    String name;
    List<Question> questionList;
    int points = 0;
    char response;

    public Quiz(String name, List<Question> questionList){
        this.name = name;
        this.questionList = questionList;
    }
    public String getName(){
        return name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void iniciar(){
        Scanner entrada = new Scanner(System.in);

        for (Question q: questionList) {
            System.out.println(q.getText());

            String r;
            do {
                System.out.println("\nResponda 'V' ou 'F': ");
                r = entrada.nextLine().trim().toUpperCase();
            } while (!r.equals("V") && !r.equals("F"));

            response = r.charAt(0);

            if ((response == 'V') == q.getResponse()) {
                points++;
            }
        }
        int result = calcularResultado();
        System.out.println("\nResultado: Você acertou %d%% do quiz!".formatted(result));

    }

    public int calcularResultado(){
        int porcAcertos = (points * 100) / questionList.size();
        points = 0;
        return porcAcertos;
    }

}