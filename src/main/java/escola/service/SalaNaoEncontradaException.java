package escola.service;

public class SalaNaoEncontradaException extends RuntimeException {

    public SalaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
