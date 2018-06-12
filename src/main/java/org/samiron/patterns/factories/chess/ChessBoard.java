package org.samiron.patterns.factories.chess;

import java.io.OutputStream;

public class ChessBoard {
    
    private final ChessPiece[] opponentPieces;
    private final ChessPiece[] selfPieces;


    public ChessBoard(ChessPiece[] selfPieces, ChessPiece[] opponentPieces) {
        this.selfPieces = selfPieces;
        this.opponentPieces = opponentPieces;
    }

    public void show(OutputStream out) {

    }
}
