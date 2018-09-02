package com.sheremet.foxminded.gof.builder;

import com.google.common.base.MoreObjects;

public final class PizzaDTO {

    private final String cheese;
    private final String bacon;
    private final String pineapple;
    private final String mushrooms;
    private final String seafood;

    /**
     * Private!!!
     */
    private PizzaDTO(String cheese, String bacon, String pineapple, String mushrooms, String seafood) {
        this.cheese = cheese;
        this.bacon = bacon;
        this.pineapple = pineapple;
        this.mushrooms = mushrooms;
        this.seafood = seafood;
    }

    public String getCheese() {
        return cheese;
    }

    public String getBacon() {
        return bacon;
    }

    public String getPineapple() {
        return pineapple;
    }

    public String getMushrooms() {
        return mushrooms;
    }

    public String getSeafood() {
        return seafood;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cheese", getCheese())
                .add("bacon", getBacon())
                .add("pineapple", getPineapple())
                .add("mushrooms", getMushrooms())
                .add("seafood", getSeafood())
                .toString();
    }

    public static final class MeatFeastPizzaBuilder {
        private String cheese = "0";
        private String bacon = "0";
        private String pineapple = "0";
        private String mushrooms = "0";
        private String seafood = "0";

        public MeatFeastPizzaBuilder cheese(int cheese) {
            this.cheese = String.format("MeatFeastPizza requires %d gram of cheese", cheese);
            return this;
        }

        public MeatFeastPizzaBuilder bacon(int bacon) {
            this.bacon = String.format("MeatFeastPizza requires %d gram of bacon", bacon);
            return this;
        }

        public MeatFeastPizzaBuilder pineapple(int pineapple) {
            this.pineapple = String.format("MeatFeastPizza requires %d gram of pineapple", pineapple);
            return this;
        }

        public MeatFeastPizzaBuilder mushrooms(int mushrooms) {
            this.mushrooms = String.format("MeatFeastPizza requires %d gram of mushrooms", mushrooms);
            return this;
        }

        public MeatFeastPizzaBuilder seafood(int seafood) {
            this.seafood = String.format("MeatFeastPizza requires %d gram of seafood", seafood);
            return this;
        }

        public PizzaDTO build() {
            return new PizzaDTO(cheese, bacon, pineapple, mushrooms, seafood);
        }
    }

    public static final class HawaiianPizzaBuilder {
        private String cheese = "0";
        private String bacon = "0";
        private String pineapple = "0";
        private String mushrooms = "0";
        private String seafood = "0";

        public HawaiianPizzaBuilder cheese(int cheese) {
            this.cheese = String.format("HawaiianPizza requires %d gram of cheese", cheese);
            return this;
        }

        public HawaiianPizzaBuilder bacon(int bacon) {
            this.bacon = String.format("HawaiianPizza requires %d gram of bacon", bacon);
            return this;
        }

        public HawaiianPizzaBuilder pineapple(int pineapple) {
            this.pineapple = String.format("HawaiianPizza requires %d gram of pineapple", pineapple);
            return this;
        }

        public HawaiianPizzaBuilder mushrooms(int mushrooms) {
            this.mushrooms = String.format("HawaiianPizza requires %d gram of mushrooms", mushrooms);
            return this;
        }

        public HawaiianPizzaBuilder seafood(int seafood) {
            this.seafood = String.format("HawaiianPizza requires %d gram of seafood", seafood);
            return this;
        }

        public PizzaDTO build() {
            return new PizzaDTO(cheese, bacon, pineapple, mushrooms, seafood);
        }
    }
}
