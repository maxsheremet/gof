package com.sheremet.foxminded.gof.abstractfactory.piece.piece;

import java.util.UUID;

public interface Piece {
    Colour getColour();

    Type getType();

    default String getId() {
        return UUID.randomUUID().toString();
    }

    enum Colour {BLACK, WHITE;}

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
