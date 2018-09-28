package com.sheremet.foxminded.gof.abstractfactor.template;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.Date;

public interface TimeService {
    void writeToFile(String fileName) throws IOException;

    abstract class AbstractServiceWriter implements TimeService {

        private final void createFile(String fileName) throws IOException {
            Files.createFile(Paths.get(fileName));
            System.out.println(String.format("Success creating the file : [%s]", fileName));
        }

        protected final void closeFile(String fileName) {
            System.out.println(String.format("Closing the file : [%s]", fileName));
        }

    }

    final class DateServiceWriter extends AbstractServiceWriter implements TimeService {

        private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance();

        @Override
        public void writeToFile(String fileName) throws IOException {
            super.createFile(fileName);
            Files.write(Paths.get(fileName), DATE_FORMAT.format(new Date()).getBytes());
            super.closeFile(fileName);
        }
    }

    final class TimeServiceWriter extends AbstractServiceWriter implements TimeService {
        private static final DateFormat TIME_FORMAT = DateFormat.getTimeInstance();

        @Override
        public void writeToFile(String fileName) throws IOException {
            super.createFile(fileName);
            Files.write(Paths.get(fileName), TIME_FORMAT.format(new Date()).getBytes());
            super.closeFile(fileName);
        }
    }
}


