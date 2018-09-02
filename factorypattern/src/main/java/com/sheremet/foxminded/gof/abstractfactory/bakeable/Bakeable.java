package com.sheremet.foxminded.gof.abstractfactory.bakeable;

public interface Bakeable {
    enum Duration {

        Short(15), Medium(30), Long(60);

        private final int value;

        Duration(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    String getBakingInstructions();
}
