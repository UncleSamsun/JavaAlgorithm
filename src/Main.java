import java.util.Scanner;

public class Main {
    static final int king = 1;
    static final int queen = 1;
    static final int rook = 2;
    static final int bishop = 2;
    static final int knight = 2;
    static final int pawn = 8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inKing = sc.nextInt();
        int inQueen = sc.nextInt();
        int inRook = sc.nextInt();
        int inBishop = sc.nextInt();
        int inKnight = sc.nextInt();
        int inPawn = sc.nextInt();

        int resultKing = king - inKing;
        int resultQueen = queen - inQueen;
        int resultRook = rook - inRook;
        int resultBishop = bishop - inBishop;
        int resultKnight = knight - inKnight;
        int resultPawn = pawn - inPawn;

        System.out.println(resultKing + " " + resultQueen + " " + resultRook + " " + resultBishop + " " + resultKnight + " " + resultPawn);

    }
}
