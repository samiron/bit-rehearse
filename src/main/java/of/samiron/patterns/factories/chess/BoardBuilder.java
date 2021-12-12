package of.samiron.patterns.factories.chess;

/**
 * Board builder knows how to place the pieces of each side on the board
 */
public class BoardBuilder {

    ChessPieceFactory selfPieceFactory;
    ChessPieceFactory remotePieceFactor;

    public ChessBoard buildBoard(){
        System.out.printf("Building %s pieces for you.", selfPieceFactory.getColor());
        ChessPiece[] selfPieces = buildPieces(selfPieceFactory);
        System.out.printf("Building %s pieces of your opponent: ", remotePieceFactor.getColor());
        ChessPiece[] opponentPieces = buildPieces(remotePieceFactor);

        return new ChessBoard(selfPieces, opponentPieces);
    }

    private ChessPiece[] buildPieces(ChessPieceFactory factory){
        return null;
    }

    public BoardBuilder setSelfPieces(ChessPieceFactory selfPieceFactory) {
        return this;
    }

    public BoardBuilder setRemotePieceFactory(ChessPieceFactory remotePieceFactory) {
        return this;
    }

    public BoardBuilder setSelfPieceFactory(ChessPieceFactory remotePieceFactory) {
        return this;
    }
}
