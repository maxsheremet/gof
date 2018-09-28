package com.sheremet.foxminded.gof.state;

import java.util.List;

import static java.util.Arrays.asList;

public interface Owen {

    int incrementState();

    String getName();

    String powerUp();

    String prepareTheMeal(String meal);

    String triggerTheAlarm();

    final class OwenImpl implements Owen {
        private final String name;
        private final List<State> states;
        private int activeState = 0;

        public OwenImpl(String name) {
            this.name = name;
            this.states = asList(new State.ColdState(this), new State.ReadyState(this), new State.OverheatedState(this));
        }

        @Override
        public int incrementState() {
            return activeState++;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String powerUp() {
            return getActiveState().powerUp();
        }

        @Override
        public String prepareTheMeal(String meal) {
            return getActiveState().prepareTheMeal(meal);
        }

        @Override
        public String triggerTheAlarm() {
            return getActiveState().triggerOverheatedAlarm();
        }

        private State getActiveState() {
            return states.get(activeState % states.size());
        }
    }

}
