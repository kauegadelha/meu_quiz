import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class QuizTest {

    @Test
    void deveCalcularPorcentagemDeAcertos() {
        List<Question> perguntas = new ArrayList<>();

        perguntas.add(new Question(1, "Java é uma linguagem?", true));
        perguntas.add(new Question(2, "A Terra é plana?", false));
        perguntas.add(new Question(3, "2 + 2 = 5?", false));

        Quiz quiz = new Quiz("Teste", perguntas);

        quiz.points = 2;

        int resultado = quiz.calcularResultado();

        assertEquals(66, resultado);
        assertEquals(0, quiz.points);
    }
}
