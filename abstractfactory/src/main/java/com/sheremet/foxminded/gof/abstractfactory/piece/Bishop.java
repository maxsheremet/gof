package com.sheremet.foxminded.gof.abstractfactory.piece;

import com.sheremet.foxminded.gof.abstractfactory.piece.piece.Piece;

public interface Bishop extends Piece {

    final class BlackBishop implements Bishop {
        @Override
        public Colour getColour() {
            return Colour.BLACK;
        }

        @Override
        public Type getType() {
            return Type.BISHOP;
        }
    }

    final class WhiteBishop implements Bishop {
        @Override
        public Colour getColour() {
            return Colour.WHITE;
        }

        @Override
        public Type getType() {
            return Type.BISHOP;
        }
    }
}
