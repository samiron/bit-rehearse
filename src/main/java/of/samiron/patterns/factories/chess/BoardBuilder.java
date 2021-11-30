package of.samiron.patterns.factories.chess;

public class BoardBuilder {

    public ChessBoard buildBoard(ChessPieceFactory selfPieceFactory, ChessPieceFactory remotePieceFactor){
        System.out.printf("Building %s pieces for you.", selfPieceFactory.getColor());
        ChessPiece[] selfPieces = buildPieces(selfPieceFactory);
        System.out.printf("Building %s pieces of your opponent: ", remotePieceFactor.getColor());
        ChessPiece[] opponentPieces = buildPieces(remotePieceFactor);

        return new ChessBoard(selfPieces, opponentPieces);
    }

    private ChessPiece[] buildPieces(ChessPieceFactory factory){
        return null;
    }
}
