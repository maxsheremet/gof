package com.sheremet.foxminded.gof.momento;

public final class DocumentMemento {

    private final String document;

    public DocumentMemento(String documet) {
        this.document = documet;
    }

    public String getDocument() {
        return document;
    }
}
