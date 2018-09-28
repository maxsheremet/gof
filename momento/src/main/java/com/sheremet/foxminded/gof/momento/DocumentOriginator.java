package com.sheremet.foxminded.gof.momento;

public final class DocumentOriginator {

    private String document;

    public DocumentOriginator setDocument(String document) {
        this.document = document;
        return this;
    }

    public DocumentMemento getDocumentMemento() {
        return new DocumentMemento(document);
    }

    public String restore(DocumentMemento documentMemento) {
        this.document = documentMemento.getDocument();
        return document;
    }
}
