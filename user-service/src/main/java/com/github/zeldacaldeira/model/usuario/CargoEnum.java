package com.github.zeldacaldeira.model.usuario;

public enum CargoEnum {
    ADMINISTRADOR("administrador"),
    USUARIO("usuario");
    private String cargo;

    CargoEnum(String nomeDoCargo) {
        this.cargo = nomeDoCargo;
    }

    public String getCargo() {
        return cargo;
    }
}