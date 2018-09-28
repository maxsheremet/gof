package com.sheremet.foxminded.gof.state;

public interface State {

    String powerUp();

    String prepareTheMeal(String item);

    String triggerOverheatedAlarm();

    final class ColdState implements State {
        private final Owen owen;

        public ColdState(Owen owen) {
            this.owen = owen;
        }

        @Override
        public String powerUp() {
            owen.incrementState();
            return owen.getName() + " ready to be used.";
        }

        @Override
        public String prepareTheMeal(String item) {
            return "Cold owen cannot prepare " + item+".";
        }

        @Override
        public String triggerOverheatedAlarm() {
            return "Cold owen cannot be overheated.";
        }
    }

    final class ReadyState implements State {
        private final Owen owen;

        public ReadyState(Owen owen) {
            this.owen = owen;
        }

        @Override
        public String powerUp() {
            return owen.getName() + " is already powered up.";
        }

        @Override
        public String prepareTheMeal(String item) {
            owen.incrementState();
            return "Preparing the meal from " + item+".";
        }

        @Override
        public String triggerOverheatedAlarm() {
            return "Ready owen is not overheated.";
        }
    }

    final class OverheatedState implements State {
        private final Owen owen;

        public OverheatedState(Owen owen) {
            this.owen = owen;
        }

        @Override
        public String powerUp() {
            return owen.getName() + " is already powered up and overheating.";
        }

        @Override
        public String prepareTheMeal(String item) {
            return item + " is burning, consider removing.";
        }

        @Override
        public String triggerOverheatedAlarm() {
            owen.incrementState();
            return owen.getName() + " needs to cool down.";
        }
    }
}
