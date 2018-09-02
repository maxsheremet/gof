package com.sheremet.foxminded.gof.bridge;

import com.sheremet.foxminded.gof.bridge.document.PdfDocument;
import com.sheremet.foxminded.gof.bridge.document.WordDocument;
import com.sheremet.foxminded.gof.bridge.printer.LinuxPrinter;
import com.sheremet.foxminded.gof.bridge.printer.Printer;
import com.sheremet.foxminded.gof.bridge.printer.WindowsPrinter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class PrinterTest {
    private final Printer windows = new WindowsPrinter();
    private final Printer linux = new LinuxPrinter();

    @Test
    public void testWindows() {
        assertThat(windows.print(new WordDocument()),
                is("Windows printer printing header=[Word Header] body=[Word Content] footer=[Word Footer]."));
        assertThat(windows.print(new PdfDocument()),
                is("Windows printer printing header=[Pdf Header] body=[Pdf Content] footer=[Pdf Footer]."));
    }

    @Test
    public void testLinux() {
        assertThat(linux.print(new WordDocument()),
                is("Linux printer printing header=[Word Header] body=[Word Content] footer=[Word Footer]."));
        assertThat(linux.print(new PdfDocument()),
                is("Linux printer printing header=[Pdf Header] body=[Pdf Content] footer=[Pdf Footer]."));
    }
}
