
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class QuizTest {

    @Test
    void deveCalcularPorcentagemComUmAcerto() {
        List<Question> perguntas = new ArrayList<>();

        perguntas.add(new Question(1, "Java é uma linguagem?", true));
        perguntas.add(new Question(2, "A Terra é plana?", false));
        perguntas.add(new Question(3, "2 + 2 = 5?", false));

        Quiz quiz = new Quiz("Teste", perguntas);

        int resultado = quiz.calculateResult(1);

        assertEquals(33, resultado);
    }

    @Test
    void deveCalcularPorcentagemComDoisAcertos() {
        List<Question> perguntas = new ArrayList<>();

        perguntas.add(new Question(1, "Java é uma linguagem?", true));
        perguntas.add(new Question(2, "A Terra é plana?", false));
        perguntas.add(new Question(3, "2 + 2 = 5?", false));

        Quiz quiz = new Quiz("Teste", perguntas);

        int resultado = quiz.calculateResult(2);

        assertEquals(66, resultado);
    }

    @Test
    void deveRetornar100PorCentoQuandoAcertarTodas() {
        List<Question> perguntas = new ArrayList<>();

        perguntas.add(new Question(1, "Java é uma linguagem?", true));
        perguntas.add(new Question(2, "A Terra é plana?", false));
        perguntas.add(new Question(3, "2 + 2 = 5?", false));

        Quiz quiz = new Quiz("Teste", perguntas);

        int resultado = quiz.calculateResult(3);

        assertEquals(100, resultado);
    }

    @Test
    void deveRetornarZeroPorCentoQuandoNaoAcertarNenhuma() {
        List<Question> perguntas = new ArrayList<>();

        perguntas.add(new Question(1, "Java é uma linguagem?", true));
        perguntas.add(new Question(2, "A Terra é plana?", false));
        perguntas.add(new Question(3, "2 + 2 = 5?", false));

        Quiz quiz = new Quiz("Teste", perguntas);

        int resultado = quiz.calculateResult(0);

        assertEquals(0, resultado);
    }
}
