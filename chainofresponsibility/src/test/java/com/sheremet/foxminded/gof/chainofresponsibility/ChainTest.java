package com.sheremet.foxminded.gof.chainofresponsibility;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ChainTest {

    /**
     * Define the order in which the implementations are invoked.
     */
    private final ChainLink chainLink = new ChainLink.FireChainLink(
            new ChainLink.AmbulanceChainLink(
                    new ChainLink.PoliceChainLink(
                            new ChainLink.UnsupportedChainLink())));

    @Test
    public void testFire() {
        assertThat(chainLink.processRequest("fire"),
                is("Sending file engine in response to fire"));
        assertThat(chainLink.processRequest("smoke"),
                is("Sending file engine in response to smoke"));
    }

    @Test
    public void testPolice() {
        assertThat(chainLink.processRequest("rape"),
                is("Sending police in response to rape"));
        assertThat(chainLink.processRequest("murder"),
                is("Sending police in response to murder"));
    }

    @Test
    public void testAmbulance() {
        assertThat(chainLink.processRequest("headache"),
                is("Sending ambulance in response to headache"));
        assertThat(chainLink.processRequest("stroke"),
                is("Sending ambulance in response to stroke"));
    }

    @Test(expected = RuntimeException.class)
    public void testUnsupported() {
        chainLink.processRequest("zzz");
    }
}
