package games;

import java.util.*;

public class TicTacToe {
    private Scanner in = new Scanner(System.in);
    private String[] board = new String[9];
    private int maxMoves = 9;
    private String winner = null;
    private boolean turn = true;

    TicTacToe(){
        Arrays.fill(board, "");
    }

    public void run() {
        while(winner == null) {
            printBoard();

            if(turn) {
                System.out.println("Player X, please enter a number between 1 and 9.");
            } else {
                System.out.println("Player O, please enter a number between 1 and 9.");
            }
            int move;
            try {
                move = in.nextInt();
                if (!(move > 0 && move <= 9)) {
                    System.out.println("Invalid input; re-enter number.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input; re-enter number.");
                continue;
            }

            move--;

            if(!board[move].equals("")) {
                System.out.println("Number was already taking; re-enter number.");
                continue;
            } else {
                board[move] = turn==true?"X":"O";
            }

            printBoard();

            winner = checkGameStatus();

            if(winner!=null) {
                System.out.println("And the winner is: " + winner);
                break;
            } else {
                turn = !turn;
            }
        }
    }

    private String checkGameStatus() {
        List<String> winningMoves = new ArrayList<>();
        winningMoves.add(new String(board[0] + board[1] + board[2]));
        winningMoves.add(new String(board[3] + board[4] + board[5]));
        winningMoves.add(new String(board[6] + board[7] + board[8]));
        winningMoves.add(new String(board[0] + board[3] + board[6]));
        winningMoves.add(new String(board[1] + board[4] + board[7]));
        winningMoves.add(new String(board[2] + board[5] + board[8]));
        winningMoves.add(new String(board[0] + board[4] + board[8]));
        winningMoves.add(new String(board[2] + board[4] + board[6]));


        if(winningMoves.contains("XXX")) {
            return "X";
        }
        if(winningMoves.contains("OOO")) {
            return "O";
        }

        boolean full = true;
        for(int i=0; i<9; i++) {
            if(board[i].equals("")) {
                full = false;
                break;
            }
        }

        if(full) {
            winner = "draw game";
            System.out.println("Draw game.");
        }

        return winner;
    }

    private void positionInputOnBoard(Move nextMove) {

    }

    private void printBoard() {
        System.out.println("");
        System.out.println("/---|---|---\\");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("\\---|---|---/");
        System.out.println("");
    }

}
