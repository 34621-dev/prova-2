
package escola.controller;

import escola.service.ConflitoException;
import escola.service.SalaNaoEncontradaException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class TratamentoErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> dadosInvalidos(
            MethodArgumentNotValidException erro) {

        String mensagem = erro.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(e -> e.getDefaultMessage())
                .orElse("Dados inválidos");

        return ResponseEntity.badRequest()
                .body(Map.of("erro", mensagem));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> jsonInvalido(
            HttpMessageNotReadableException erro) {

        return ResponseEntity.badRequest()
                .body(Map.of("erro", "JSON inválido"));
    }

    @ExceptionHandler(ConflitoException.class)
    public ResponseEntity<Map<String, String>> conflito(
            ConflitoException erro) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("erro", erro.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> integridade(
            DataIntegrityViolationException erro) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("erro", "Conflito nos dados cadastrados"));
    }

    @ExceptionHandler(SalaNaoEncontradaException.class)
    public ResponseEntity<Map<String, String>> naoEncontrado(
            SalaNaoEncontradaException erro) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("erro", erro.getMessage()));
    }
}
