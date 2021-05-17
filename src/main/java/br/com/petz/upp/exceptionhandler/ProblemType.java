package br.com.petz.upp.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    INVALID_DATA("/dados-invalidos", "Invalid Data"),
    SYSTEM_ERROR("/erro-de-sistema", "System error"),
    INVALID_PARAMETER("/parametro-invalido", "Invalid parameter"),
    INCOMPREHENSIBLE_MESSAGE("/mensagem-incompreensivel", "Incomprehensible message"),
    RESOURCE_NOT_FOUND("/recurso-nao-encontrado", "Resource not found"),
    ENTITY_IN_USE("/entidade-em-uso", "Entity in use"),
    BUSINESS_ERROR("/erro-negocio", "Business rule violation");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://www.petz.com.br" + path;
        this.title = title;
    }

}
