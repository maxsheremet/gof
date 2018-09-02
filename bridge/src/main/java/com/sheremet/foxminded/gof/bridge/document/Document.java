package com.sheremet.foxminded.gof.bridge.document;

public interface Document {
    /**
     * {@link Document} contract.
     */
    String getHeader();

    String getContent();

    String getFooter();

    /**
     * {@link PdfDocument} implementation.
     */
    final class PdfDocument implements Document {
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

    /**
     * {@link WordDocument} implementation.
     */
    final class WordDocument implements Document {
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
}
