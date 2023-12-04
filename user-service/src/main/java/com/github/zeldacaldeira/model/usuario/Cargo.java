package com.github.zeldacaldeira.model.usuario;

public enum Cargo {
    ADMINISTRADOR("administrador"),
    USUARIO("usuario");
    private String cargo;

    Cargo(String nomeDoCargo) {
        this.cargo = nomeDoCargo;
    }

    public String getCargo() {
        return cargo;
    }
}