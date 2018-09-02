package com.sheremet.foxminded.gof.abstractfactory.bakeable;

public interface Bakeable {
    /**
     * Inteface contract.
     */
    String getBakingInstructions();

    /**
     * Shared enum.
     */
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

    /**
     * Toast implementation.
     */
    final class Toast implements Bakeable {

        private final Duration duration;

        public Toast(Duration duration) {
            this.duration = duration;
        }

        public String getBakingInstructions() {
            return String.format("Toast takes %d to bake.", duration.getValue());
        }
    }

    /**
     * Pizza implementation.
     */
    final class Pizza implements Bakeable {
        private final Duration duration;

        public Pizza(Duration duration) {
            this.duration = duration;
        }

        public String getBakingInstructions() {
            return String.format("Pie takes %d mins to bake.", duration.getValue());
        }
    }

    /**
     * Pie implementation.
     */
    final class Pie implements Bakeable {
        private final Duration duration;

        public Pie(Duration duration) {
            this.duration = duration;
        }

        public String getBakingInstructions() {
            return String.format("Pie takes %d mins to bake.", duration.getValue());
        }
    }
}
