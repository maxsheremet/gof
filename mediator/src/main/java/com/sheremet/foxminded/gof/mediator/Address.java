package com.sheremet.foxminded.gof.mediator;

public interface Address {

    String getAddress();

    enum AddressImpl implements Address {
        Airport {
            @Override
            public String getAddress() {
                return "Airport";
            }
        }, Home {
            @Override
            public String getAddress() {
                return "Home";
            }
        }, Hotel {
            @Override
            public String getAddress() {
                return "Hotel";
            }
        }
    }
}
