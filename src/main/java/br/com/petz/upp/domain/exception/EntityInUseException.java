package br.com.petz.upp.domain.exception;

public class EntityInUseException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EntityInUseException(String mensagem) {
        super(mensagem);
    }

}