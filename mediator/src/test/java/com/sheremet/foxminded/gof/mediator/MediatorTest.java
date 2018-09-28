package com.sheremet.foxminded.gof.mediator;

import org.junit.Test;

import static com.sheremet.foxminded.gof.mediator.Address.AddressImpl.*;
import static com.sheremet.foxminded.gof.mediator.DeliveryService.DeliveryServiceImpl.*;
import static com.sheremet.foxminded.gof.mediator.EmergencyService.EmergencyServiceImpl.*;
import static com.sheremet.foxminded.gof.mediator.Mediator.MediatorImpl.RegularMediator;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class MediatorTest {

    private static final Mediator MEDIATOR = RegularMediator;

    @Test
    public void testPlaceAnOrder() {
        assertThat(MEDIATOR.placeAnOrder(Flowers, Airport),
                is("Order placed for [Flowers] to be dispatched to [Airport]."));
        assertThat(MEDIATOR.placeAnOrder(Taxi, Hotel),
                is("Order placed for [Taxi] to be dispatched to [Hotel]."));
        assertThat(MEDIATOR.placeAnOrder(Pizza, Home),
                is("Order placed for [Pizza] to be dispatched to [Home]."));
    }

    @Test
    public void testReportTrouble() {
        assertThat(MEDIATOR.reportTrouble(Ambiance, Airport),
                is("[Ambiance] investigating the emergency at the address [Airport]."));
        assertThat(MEDIATOR.reportTrouble(Police, Hotel),
                is("[Police] investigating the emergency at the address [Hotel]."));
        assertThat(MEDIATOR.reportTrouble(Fire, Home),
                is("[Fire] investigating the emergency at the address [Home]."));
    }
}
