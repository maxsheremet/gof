package com.sheremet.foxminded.gof.abstractfactory;

import com.sheremet.foxminded.gof.abstractfactor.factory.Factory;
import com.sheremet.foxminded.gof.abstractfactor.factory.abstractfactory.AbstractFactory;
import com.sheremet.foxminded.gof.abstractfactory.piece.piece.Piece;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static com.sheremet.foxminded.gof.abstractfactory.piece.piece.Piece.Type.*;
import static junit.framework.TestCase.assertEquals;

public final class AbstractFactoryTest {

    public static Predicate<Piece> isBlack() {
        return piece -> Piece.Colour.BLACK.equals(piece.getColour());
    }

    public static Predicate<Piece> isWhite() {
        return piece -> Piece.Colour.WHITE.equals(piece.getColour());
    }

    private final AbstractFactory blackAbstractFactory = new AbstractFactory(new Factory.BlackFactory());
    private final AbstractFactory whiteAbstractFactory = new AbstractFactory(new Factory.WhiteFactory());

    @Test
    public void testBlack() {
        Map<Piece.Type, List<? extends Piece>> pieces = blackAbstractFactory.getPieces();
        assertEquals(KING.getQty(), pieces.get(KING).stream().filter(isBlack()).count());
        assertEquals(QUEEN.getQty(), pieces.get(QUEEN).stream().filter(isBlack()).count());
        assertEquals(BISHOP.getQty(), pieces.get(BISHOP).stream().filter(isBlack()).count());
        assertEquals(CASTLE.getQty(), pieces.get(CASTLE).stream().filter(isBlack()).count());
        assertEquals(KNIGHT.getQty(), pieces.get(KNIGHT).stream().filter(isBlack()).count());
        assertEquals(PAWN.getQty(), pieces.get(PAWN).stream().filter(isBlack()).count());
    }


    @Test
    public void testWhite() {
        Map<Piece.Type, List<? extends Piece>> pieces = whiteAbstractFactory.getPieces();
        assertEquals(KING.getQty(), pieces.get(KING).stream().filter(isWhite()).count());
        assertEquals(QUEEN.getQty(), pieces.get(QUEEN).stream().filter(isWhite()).count());
        assertEquals(BISHOP.getQty(), pieces.get(BISHOP).stream().filter(isWhite()).count());
        assertEquals(CASTLE.getQty(), pieces.get(CASTLE).stream().filter(isWhite()).count());
        assertEquals(KNIGHT.getQty(), pieces.get(KNIGHT).stream().filter(isWhite()).count());
        assertEquals(PAWN.getQty(), pieces.get(PAWN).stream().filter(isWhite()).count());
    }
}
