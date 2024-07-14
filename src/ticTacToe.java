import java.util.Arrays;
import java.util.Scanner;

public class ticTacToe {
    public static void main(String[] args) {
        char[][] board=new char[3][3];

        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
        Scanner scanner=new Scanner(System.in);
        char player='X';
        boolean gameOver=false;

        //until the game over
        while(!gameOver) {
            System.out.println("Player "+player+" play : ");
            printBoard(board);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = hasWon(board, player);
                if (!gameOver) {
                    player = player == 'X' ? 'O' : 'X';
                }else{
                    System.out.println("Player "+ player+" won!");
                }
            } else {
                System.out.println("invalid,try again");
            }
        }
        printBoard(board);
    }

    private static boolean hasWon(char[][] board, char player) {
        //row check
        for(int row=0;row<board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
                return true;
            }
        }
        for(int col=0;col<board.length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
                return true;
            }
        }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
            return true;
        }
        if(board[2][0]==player && board[1][1]==player && board[0][2]==player) {
            return true;
        }

        return false;
    }

    private static void printBoard(char[][] board) {
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }
}