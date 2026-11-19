package br.com.meuquiz.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void deveRetornarBadRequestQuandoIllegalArgumentExceptionForLancada() {
        var ex = new IllegalArgumentException("Parâmetro inválido");

        var response = handler.handleIllegalArgument(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Parâmetro inválido", response.getBody().get("error"));
    }

    @Test
    void deveRetornarConflictQuandoIllegalStateExceptionForLancada() {
        var ex = new IllegalStateException("Estado inválido");

        var response = handler.handleIllegalState(ex);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Estado inválido", response.getBody().get("error"));
    }
}