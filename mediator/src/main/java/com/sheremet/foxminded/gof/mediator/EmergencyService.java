package com.sheremet.foxminded.gof.mediator;

public interface EmergencyService {

    String investigateProblem();

    enum EmergencyServiceImpl implements EmergencyService {
        Fire {
            @Override
            public String investigateProblem() {
                return "Fire";
            }
        }, Police {
            @Override
            public String investigateProblem() {
                return "Police";
            }
        }, Ambiance {
            @Override
            public String investigateProblem() {
                return "Ambiance";
            }
        }
    }
}