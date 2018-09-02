package com.sheremet.foxminded.gof.abstractfactory.piece;

import com.sheremet.foxminded.gof.abstractfactory.piece.piece.Piece;

public interface Pawn extends Piece {

    final class BlackPawn implements Pawn {
        @Override
        public Colour getColour() {
            return Colour.BLACK;
        }

        @Override
        public Type getType() {
            return Type.PAWN;
        }
    }

    final class WhitePawn implements Pawn {
        @Override
        public Colour getColour() {
            return Colour.WHITE;
        }

        @Override
        public Type getType() {
            return Type.PAWN;
        }
    }
}
