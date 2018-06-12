package org.samiron.patterns.factories.chess;

enum PieceType {
    KING,
    QUEEN,
    ROOK,
    BISHOP,
    KNIGHT,
    PAWN
}

enum PieceColor {
    WHITE,
    BLACK
}

public abstract class ChessPiece {
    protected PieceType pieceType;
    protected PieceColor pieceColor;
    protected BoardCell cell;

    protected ChessPiece(PieceType type, PieceColor color){
        this.pieceType = type;
        this.pieceColor = color;
    }

    public void setCell(BoardCell cell){
        this.cell = cell;
    }

    public BoardCell getCell(){
        return this.cell;
    }

    public boolean isWhite(){
        return this.pieceColor.equals(PieceColor.WHITE);
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    /**
     * Other abstract methods should be here that defines behavior of individual pieces
     */
}

class King extends ChessPiece {
    public King(PieceColor color) {
        super(PieceType.KING, color);
    }
}
class Queen extends ChessPiece {
    public Queen(PieceColor color) {
        super(PieceType.QUEEN, color);
    }
}
class Bishop extends ChessPiece {
    public Bishop(PieceColor color) {
        super(PieceType.BISHOP, color);
    }
}
class Knight extends ChessPiece {
    public Knight(PieceColor color) {
        super(PieceType.KNIGHT, color);
    }
}
class Rook extends ChessPiece {
    public Rook(PieceColor color) {
        super(PieceType.ROOK, color);
    }
}
class Pawn extends ChessPiece {
    public Pawn(PieceColor color) {
        super(PieceType.PAWN, color);
    }
}
