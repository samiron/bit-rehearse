package of.samiron.patterns.factories.chess;

import java.util.Scanner;

public class ChessMain {

    public static void main(String[] args) {
        ChessMain main = new ChessMain();

        Scanner scanner = new Scanner(System.in);
        String input;
        askInput();
        while(!(input = scanner.nextLine()).equalsIgnoreCase("q")){
            ChessPieceFactory selfPieceFactory = null, remotePieceFactory = null;
            if(input.equalsIgnoreCase("w")){
                selfPieceFactory = new WhitePieceFactory();
                remotePieceFactory = new BlackPieceFactory();
            } else if(input.equalsIgnoreCase("b")) {
                selfPieceFactory = new BlackPieceFactory();
                remotePieceFactory = new WhitePieceFactory();
            }

            ChessBoard board = new BoardBuilder().buildBoard(selfPieceFactory, remotePieceFactory);
            board.show(System.out);

            askInput();
        }
    }

    private static void askInput() {
        System.out.println("Type [B/W] to choose Black/White or Q to quit: ");
    }
}
