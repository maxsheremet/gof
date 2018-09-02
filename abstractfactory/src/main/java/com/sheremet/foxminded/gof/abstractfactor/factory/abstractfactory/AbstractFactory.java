package com.sheremet.foxminded.gof.abstractfactor.factory.abstractfactory;

import com.sheremet.foxminded.gof.abstractfactor.factory.Factory;
import com.sheremet.foxminded.gof.abstractfactory.piece.piece.Piece;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link AbstractFactory} using whatever factory to create a map of pieces.
 */
public final class AbstractFactory {

    private final Map<Piece.Type, List<? extends Piece>> pieces = new HashMap<>();

    public AbstractFactory(Factory factory) {
        pieces.put(Piece.Type.KING, factory.buildKing());
        pieces.put(Piece.Type.QUEEN, factory.buildQueen());
        pieces.put(Piece.Type.BISHOP, factory.buildBishop());
        pieces.put(Piece.Type.CASTLE, factory.buildCastle());
        pieces.put(Piece.Type.KNIGHT, factory.buildKnight());
        pieces.put(Piece.Type.PAWN, factory.buildPawn());
    }

    public Map<Piece.Type, List<? extends Piece>> getPieces() {
        return Collections.unmodifiableMap(pieces);
    }
}
