import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        int option, questionCount = 4;
        String questionText, quizName = "meu_quiz";
        char response;
        Quiz quiz = null;

        Scanner scanner = new Scanner(System.in);

        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1: if (quiz != null) {
                            System.out.println("O Quiz já está criado!");
                        } else {
                            List<Question> questionList = new ArrayList<>();

                            for (int i = 1; i <= questionCount; i++) {
                                System.out.println("Crie uma questão: ");
                                questionText = scanner.nextLine();

                                String r;
                                do {
                                    System.out.println("Verdadeiro ou Falso? Digite 'V' ou 'F': ");
                                    r = scanner.nextLine().trim().toUpperCase();
                                } while (!r.equals("V") && !r.equals("F"));

                                response = r.charAt(0);

                                Question q;
                                if (response == 'V') q = new Question(i, questionText, true);
                                else q = new Question(i, questionText, false);

                                questionList.add(q);
                            }
                            quiz = new Quiz(quizName, questionList);
                        }
                        break;
                case 2: if (quiz == null) {
                           System.out.println("O Quiz não está criado!");
                        } else {
                            quiz.start(scanner);
                        }
                        break;
                case 3: System.out.println("\nSaindo...");
                        break;
                default: System.out.println("\nOpção inválida!");
            }

        } while(option != 3);
    }

    public static void displayMenu(){
        System.out.println("=========MENU==========");
        System.out.println("|| [1] Criar Quiz.   ||");
        System.out.println("|| [2] Iniciar Quiz. ||");
        System.out.println("|| [3] Sair.         ||");
        System.out.println("=======================\nSelecione uma opção: ");

    }
}
