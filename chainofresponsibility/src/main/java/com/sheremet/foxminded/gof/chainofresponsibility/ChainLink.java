package com.sheremet.foxminded.gof.chainofresponsibility;

import java.util.List;

import static java.util.Arrays.asList;

public interface ChainLink {
    /**
     * Interface contract.
     */
    String processRequest(String request);

    /**
     * Impl to handle ambulance calls.
     */
    final class AmbulanceChainLink implements ChainLink {

        private final List<String> supportedRequests = asList("stroke", "headache");
        private final ChainLink next;

        public AmbulanceChainLink(ChainLink next) {
            this.next = next;
        }

        @Override
        public String processRequest(String request) {
            return supportedRequests.contains(request.toLowerCase())
                    ? String.format("Sending ambulance in response to %s", request)
                    : next.processRequest(request);
        }
    }

    /**
     * Impl to handle fire calls.
     */
    final class FireChainLink implements ChainLink {

        private final List<String> supportedRequests = asList("fire", "smoke");
        private final ChainLink next;

        public FireChainLink(ChainLink next) {
            this.next = next;
        }

        @Override
        public String processRequest(String request) {
            return supportedRequests.contains(request.toLowerCase())
                    ? String.format("Sending file engine in response to %s", request)
                    : next.processRequest(request);
        }
    }

    /**
     * Impl to handle police calls.
     */
    final class PoliceChainLink implements ChainLink {

        private final List<String> supportedRequests = asList("rape", "murder");
        private final ChainLink next;

        public PoliceChainLink(ChainLink next) {
            this.next = next;
        }

        @Override
        public String processRequest(String request) {
            return supportedRequests.contains(request.toLowerCase())
                    ? String.format("Sending police in response to %s", request)
                    : next.processRequest(request);
        }
    }

    /**
     * Impl to handle unsupported calls.
     */
    final class UnsupportedChainLink implements ChainLink {
        @Override
        public String processRequest(String request) {
            throw new RuntimeException(String.format("Cannot process %s", request));
        }
    }
}
