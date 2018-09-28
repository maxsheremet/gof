package com.sheremet.foxminded.gof.mediator;

public interface Mediator {

    String placeAnOrder(DeliveryService deliveryService, Address address);

    String reportTrouble(EmergencyService emergencyService, Address address);

    enum MediatorImpl implements Mediator {
        RegularMediator {
            @Override
            public String placeAnOrder(DeliveryService deliveryService, Address address) {
                return String.format("Order placed for [%s] to be dispatched to [%s].",
                        deliveryService.placeOrder(),
                        address.getAddress());
            }

            @Override
            public String reportTrouble(EmergencyService emergencyService, Address address) {
                return String.format("[%s] investigating the emergency at the address [%s].",
                        emergencyService.investigateProblem(),
                        address.getAddress());
            }
        };
    }

}
