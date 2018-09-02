package com.sheremet.foxminded.gof.abstractfactory.piece.piece;

/**
 * Common behaviour of all {@link Piece}.
 */
public interface Piece {
    /**
     * Contract.
     */
    Colour getColour();

    Type getType();

    /**
     * Shared enums.
     */
    enum Colour {
        BLACK, WHITE;
    }

    enum Type {
        KING(1), QUEEN(1), CASTLE(2), KNIGHT(2), BISHOP(2), PAWN(8);
        private final int qty;

        Type(int qty) {
            this.qty = qty;
        }

        public int getQty() {
            return qty;
        }
    }
}
