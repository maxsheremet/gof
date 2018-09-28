package com.sheremet.foxminded.gof.abstractfactor.template;

import org.junit.AfterClass;
import org.junit.Test;

import java.io.IOException;

import static java.nio.file.Files.delete;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class TimeServiceTest {

    private static final String DATE_FILE = "dateFile.txt";
    private static final String TIME_FILE = "timeFile.txt";

    private final TimeService dateService = new TimeService.DateServiceWriter();
    private final TimeService timeService = new TimeService.TimeServiceWriter();


    @AfterClass
    public static void destroy() throws IOException {
        delete(get(DATE_FILE));
        delete(get(TIME_FILE));
    }

    @Test
    public void dateService() throws IOException {
        dateService.writeToFile(DATE_FILE);
        assertThat(new String(readAllBytes(get(DATE_FILE))).length(), is("DD-MMM-YYYY".length()));
    }

    @Test
    public void timeService() throws IOException {
        timeService.writeToFile(TIME_FILE);
        assertThat(new String(readAllBytes(get(TIME_FILE))).length(), is("HH:MM:SS".length()));
    }
}
