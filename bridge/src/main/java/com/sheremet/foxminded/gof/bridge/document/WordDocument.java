package com.sheremet.foxminded.gof.bridge.document;

public final class WordDocument implements Document{
    @Override
    public String getHeader() {
        return "Word Header";
    }

    @Override
    public String getContent() {
        return "Word Content";
    }

    @Override
    public String getFooter() {
        return "Word Footer";
    }
}
