package com.sheremet.foxminded.gof.abstractfactor.factory;

import com.sheremet.foxminded.gof.abstractfactory.piece.*;
import com.sheremet.foxminded.gof.abstractfactory.piece.piece.Piece;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * {@link Factory} to define all pieces for the game.
 */
public interface Factory {

    List<King> buildKing();

    List<Queen> buildQueen();

    List<Castle> buildCastle();

    List<Bishop> buildBishop();

    List<Knight> buildKnight();

    List<Pawn> buildPawn();

    /**
     * Black impl.
     */
    final class BlackFactory implements Factory {

        @Override
        public List<King> buildKing() {
            return IntStream.range(0, Piece.Type.KING.getQty())
                    .mapToObj(index -> new King.BlackKing())
                    .collect(toList());
        }

        @Override
        public List<Queen> buildQueen() {
            return IntStream.range(0, Piece.Type.QUEEN.getQty())
                    .mapToObj(index -> new Queen.BlackQueen())
                    .collect(toList());
        }

        @Override
        public List<Castle> buildCastle() {
            return IntStream.range(0, Piece.Type.CASTLE.getQty())
                    .mapToObj(index -> new Castle.BlackCastle())
                    .collect(toList());
        }

        @Override
        public List<Bishop> buildBishop() {
            return IntStream.range(0, Piece.Type.BISHOP.getQty())
                    .mapToObj(index -> new Bishop.BlackBishop())
                    .collect(toList());
        }

        @Override
        public List<Knight> buildKnight() {
            return IntStream.range(0, Piece.Type.KNIGHT.getQty())
                    .mapToObj(index -> new Knight.BlackKnight())
                    .collect(toList());
        }

        @Override
        public List<Pawn> buildPawn() {
            return IntStream.range(0, Piece.Type.PAWN.getQty())
                    .mapToObj(index -> new Pawn.BlackPawn())
                    .collect(toList());
        }
    }

    /**
     * White impl.
     */
    final class WhiteFactory implements Factory {

        @Override
        public List<King> buildKing() {
            return IntStream.range(0, Piece.Type.KING.getQty())
                    .mapToObj(index -> new King.WhiteKing())
                    .collect(toList());
        }

        @Override
        public List<Queen> buildQueen() {
            return IntStream.range(0, Piece.Type.QUEEN.getQty())
                    .mapToObj(index -> new Queen.WhiteQueen())
                    .collect(toList());
        }

        @Override
        public List<Castle> buildCastle() {
            return IntStream.range(0, Piece.Type.CASTLE.getQty())
                    .mapToObj(index -> new Castle.WhiteCastle())
                    .collect(toList());
        }

        @Override
        public List<Bishop> buildBishop() {
            return IntStream.range(0, Piece.Type.BISHOP.getQty())
                    .mapToObj(index -> new Bishop.WhiteBishop())
                    .collect(toList());
        }

        @Override
        public List<Knight> buildKnight() {
            return IntStream.range(0, Piece.Type.KNIGHT.getQty())
                    .mapToObj(index -> new Knight.WhiteKnight())
                    .collect(toList());
        }

        @Override
        public List<Pawn> buildPawn() {
            return IntStream.range(0, Piece.Type.PAWN.getQty())
                    .mapToObj(index -> new Pawn.WhitePawn())
                    .collect(toList());
        }
    }
}
