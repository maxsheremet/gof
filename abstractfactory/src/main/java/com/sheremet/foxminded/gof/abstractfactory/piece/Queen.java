package com.sheremet.foxminded.gof.abstractfactory.piece;

import com.sheremet.foxminded.gof.abstractfactory.piece.piece.Piece;

public interface Queen extends Piece {
    final class BlackQueen implements Queen {
        @Override
        public Colour getColour() {
            return Colour.BLACK;
        }

        @Override
        public Type getType() {
            return Type.QUEEN;
        }
    }

    final class WhiteQueen implements Queen {
        @Override
        public Piece.Colour getColour() {
            return Colour.WHITE;
        }

        @Override
        public Type getType() {
            return Type.QUEEN;
        }
    }
}