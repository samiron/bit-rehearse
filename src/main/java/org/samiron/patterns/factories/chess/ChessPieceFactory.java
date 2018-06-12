package org.samiron.patterns.factories.chess;

public abstract class ChessPieceFactory {

    public King createKing() {
        return new King(getColor());
    }

    public Queen createQueen() {
        return new Queen(getColor());
    }

    public Bishop createBishop() {
        return new Bishop(getColor());
    }

    public Knight createKnight() {
        return new Knight(getColor());
    }

    public Rook createRook() {
        return new Rook(getColor());
    }

    public Pawn createPawn() {
        return new Pawn(getColor());
    }

    protected abstract PieceColor getColor();
}

class WhitePieceFactory extends ChessPieceFactory {
    private static PieceColor COLOR = PieceColor.WHITE;

    @Override
    protected PieceColor getColor() {
        return COLOR;
    }
}

class BlackPieceFactory extends ChessPieceFactory {

    private static PieceColor COLOR = PieceColor.BLACK;

    @Override
    protected PieceColor getColor() {
        return COLOR;
    }
}
