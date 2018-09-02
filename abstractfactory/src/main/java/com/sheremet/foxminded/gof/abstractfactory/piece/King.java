package com.sheremet.foxminded.gof.abstractfactory.piece;

import com.sheremet.foxminded.gof.abstractfactory.piece.piece.Piece;

public interface King extends Piece {

    final class BlackKing implements King {
        @Override
        public Colour getColour() {
            return Colour.BLACK;
        }

        @Override
        public Type getType() {
            return Type.KING;
        }
    }

    final class WhiteKing implements King {
        @Override
        public Colour getColour() {
            return Colour.WHITE;
        }

        @Override
        public Type getType() {
            return Type.KING;
        }
    }
}
