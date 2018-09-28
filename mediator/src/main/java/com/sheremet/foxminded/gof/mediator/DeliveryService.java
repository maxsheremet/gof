package com.sheremet.foxminded.gof.mediator;

public interface DeliveryService {
    String placeOrder();

    enum DeliveryServiceImpl implements DeliveryService {
        Pizza {
            @Override
            public String placeOrder() {
                return "Pizza";
            }
        }, Taxi {
            @Override
            public String placeOrder() {
                return "Taxi";
            }
        }, Flowers {
            @Override
            public String placeOrder() {
                return "Flowers";
            }
        }
    }
}
