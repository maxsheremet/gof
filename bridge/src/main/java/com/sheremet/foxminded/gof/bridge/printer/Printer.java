package com.sheremet.foxminded.gof.bridge.printer;

import com.sheremet.foxminded.gof.bridge.document.Document;

public interface Printer {
    /**
     * {@link Printer} contract.
     */
    String print(Document document);

    /**
     * {@link LinuxPrinter} implmenetation
     */
    final class LinuxPrinter implements Printer {
        @Override
        public String print(Document document) {
            return String.format("Linux printer printing header=[%s] body=[%s] footer=[%s].",
                    document.getHeader(),
                    document.getContent(),
                    document.getFooter());
        }
    }

    /**
     * {@link WindowsPrinter} implementation.
     */
    final class WindowsPrinter implements Printer {
        @Override
        public String print(Document document) {
            return String.format("Windows printer printing header=[%s] body=[%s] footer=[%s].",
                    document.getHeader(),
                    document.getContent(),
                    document.getFooter());
        }
    }
}
