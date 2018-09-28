package com.sheremet.foxminded.gof.observer;

public interface Observable {
    int getStrength();

    String getName();

    int incrementStrength(int offset);

    final class Storm implements Observable {

        private int stength;
        private final String name;

        public Storm(String name, int stength) {
            this.name = name;
            this.stength = stength;
        }

        @Override
        public final int getStrength() {
            return stength;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int incrementStrength(int offset) {
            return stength += offset;
        }
    }
}
