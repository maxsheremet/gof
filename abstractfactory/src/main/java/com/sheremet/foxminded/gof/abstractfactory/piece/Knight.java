package com.sheremet.foxminded.gof.abstractfactory.piece;

import com.sheremet.foxminded.gof.abstractfactory.piece.piece.Piece;

public interface Knight extends Piece {
    final class BlackKnight implements Knight {
        @Override
        public Colour getColour() {
            return Colour.BLACK;
        }

        @Override
        public Type getType() {
            return Type.KNIGHT;
        }
    }

    final class WhiteKnight implements Knight {
        @Override
        public Colour getColour() {
            return Colour.WHITE;
        }

        @Override
        public Type getType() {
            return Type.KNIGHT;
        }
    }
}
