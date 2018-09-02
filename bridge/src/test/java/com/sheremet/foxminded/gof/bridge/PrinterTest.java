package com.sheremet.foxminded.gof.bridge;

import com.sheremet.foxminded.gof.bridge.document.Document;
import com.sheremet.foxminded.gof.bridge.printer.Printer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class PrinterTest {
    private final Printer windows = new Printer.WindowsPrinter();
    private final Printer linux = new Printer.LinuxPrinter();

    @Test
    public void testWindows() {
        assertThat(windows.print(new Document.WordDocument()),
                is("Windows printer printing header=[Word Header] body=[Word Content] footer=[Word Footer]."));
        assertThat(windows.print(new Document.PdfDocument()),
                is("Windows printer printing header=[Pdf Header] body=[Pdf Content] footer=[Pdf Footer]."));
    }

    @Test
    public void testLinux() {
        assertThat(linux.print(new Document.WordDocument()),
                is("Linux printer printing header=[Word Header] body=[Word Content] footer=[Word Footer]."));
        assertThat(linux.print(new Document.PdfDocument()),
                is("Linux printer printing header=[Pdf Header] body=[Pdf Content] footer=[Pdf Footer]."));
    }
}
