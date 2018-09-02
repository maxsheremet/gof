package com.sheremet.foxminded.gof.bridge.printer;

import com.sheremet.foxminded.gof.bridge.document.Document;

public final class LinuxPrinter implements Printer {
    @Override
    public String print(Document document) {
        return String.format("Linux printer printing header=[%s] body=[%s] footer=[%s].",
                document.getHeader(),
                document.getContent(),
                document.getFooter());
    }
}
