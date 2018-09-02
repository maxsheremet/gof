package com.sheremet.foxminded.gof.bridge.document;

public final class PdfDocument implements Document {
    @Override
    public String getHeader() {
        return "Pdf Header";
    }

    @Override
    public String getContent() {
        return "Pdf Content";
    }

    @Override
    public String getFooter() {
        return "Pdf Footer";
    }
}
