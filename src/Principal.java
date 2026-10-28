import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        int option, qtd_questions = 3;
        String text, name = "meu_quiz";
        char response;
        Quiz quiz = null;

        Scanner entrada = new Scanner(System.in);

        do {
            menu();
            option = entrada.nextInt();
            entrada.nextLine();

            switch (option){
                case 1: if (quiz != null) {
                            System.out.println("O Quiz já está criado!");
                        } else {
                            List<Question> questionList = new ArrayList<>();

                            for (int i = 1; i <= qtd_questions; i++) {
                                System.out.println("Crie uma questão: ");
                                text = entrada.nextLine();

                                String r;
                                do {
                                    System.out.println("Verdadeiro ou Falso? Digite 'V' ou 'F': ");
                                    r = entrada.nextLine().trim().toUpperCase();
                                } while (!r.equals("V") && !r.equals("F"));

                                response = r.charAt(0);

                                Question q;
                                if (response == 'V') q = new Question(i, text, true);
                                else q = new Question(i, text, false);

                                questionList.add(q);
                            }
                            quiz = new Quiz(name, questionList);
                        }
                        break;
                case 2: if (quiz == null) {
                           System.out.println("O Quiz não está criado!");
                        } else {
                            quiz.iniciar();
                        }
                        break;
                case 3: System.out.println("\nSaindo...");
                        break;
                default: System.out.println("\nOpção inválida!");
            }

        } while(option != 3);
    }

    public static void menu(){
        System.out.println("=========MENU==========");
        System.out.println("|| [1] Criar Quiz.   ||");
        System.out.println("|| [2] Iniciar Quiz. ||");
        System.out.println("|| [3] Sair.         ||");
        System.out.println("=======================\nSelecione uma opção: ");

    }
}
