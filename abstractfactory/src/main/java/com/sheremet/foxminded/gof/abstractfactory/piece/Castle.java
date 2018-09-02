package com.sheremet.foxminded.gof.abstractfactory.piece;

import com.sheremet.foxminded.gof.abstractfactory.piece.piece.Piece;

public interface Castle extends Piece {
    final class BlackCastle implements Castle {
        @Override
        public Colour getColour() {
            return Colour.BLACK;
        }

        @Override
        public Type getType() {
            return Type.CASTLE;
        }

    }

    final class WhiteCastle implements Castle {
        @Override
        public Colour getColour() {
            return Colour.WHITE;
        }

        @Override
        public Type getType() {
            return Type.CASTLE;
        }
    }
}
