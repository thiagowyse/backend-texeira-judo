package com.projetojudo.judotexeira.core.enums;

public enum Role {
    ADMIN,
    EDITOR,
    VIEWER;

    public String asString() {
        return this.name().toLowerCase();
    }
}
