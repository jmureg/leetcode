package games;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Minesweeper {

    private static String EMPTY = "  ";
    private static String MINE = " * ";
    private static String UNKNOWN = " ? ";
    private int size;
    private int mines;
    private boolean debug = false;
    private String[][] hidden = null;
    private String[][] open = null;
    private boolean won = false;
    private boolean lost = false;
    private int moves = -1;

    public Minesweeper(int size, int mines) {
        this.size = size;
        this.mines = mines;
        this.moves = this.size * this.size;
        this.hidden = new String[this.size][this.size];
        this.open = new String[this.size][this.size];

        initField();
        placeMines();
    }

    private void initField() {

        for (String[] line : this.hidden
        ) {
            Arrays.fill(line, UNKNOWN);
        }
        for (String[] line : this.open
        ) {
            Arrays.fill(line, UNKNOWN);
        }
    }

    private void placeMines() {
        int toplace = this.mines;
        int xm, ym = 0;
        boolean done = false;

        for (int x = 0; x < this.size && !done; x++) {
            for (int y = 0; y < this.size && !done; y++) {
                xm = (int) (this.size * Math.random());
                ym = (int) (this.size * Math.random());
                if (!hidden[xm][ym].equals(MINE)) {
                    hidden[xm][ym] = MINE;
                    if (--toplace == 0) {
                        done = true;
                    }
                }
            }
        }
    }

    public void run() {
        System.out.println("Welcome to Minesweeper!");

        while (!(won || lost)) {
            print();
            Move move = readNextMove();
            nextMove(move);
        }

    }

    private void nextMove(Move move) {
        if (hidden[move.xAsint()][move.yAsint()].equals(UNKNOWN)) {
            open[move.xAsint()][move.yAsint()] = EMPTY;
            System.out.println("Move x: " + move.xAsint() + " and y: " + move.yAsint() + " was accepted.");

            updateOpen();
            print();
            this.moves--;
            if (this.moves == this.mines) {
                this.won = validate();
                if (this.won) {
                    System.out.println("Congratulations. You've won Minesweeper!");
                }
            }
        } else if (hidden[move.xAsint()][move.yAsint()].equals(MINE)) {
            open[move.xAsint()][move.yAsint()] = MINE;
            this.lost = true;
            System.out.println("Game over - you've hit a mine on x: " + move.xAsint() + " and y: " + move.yAsint());
        }
    }

    private boolean validate() {
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                if (this.open[x][y].equals(UNKNOWN) == true) {
                    if (!this.hidden[x][y].equals(MINE)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void updateOpen() {
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                if (this.open[x][y].equals(EMPTY) == true) {
                    int mines = 0;
                    int xstart = x - 1;
                    int xend = x + 1;
                    int ystart = y - 1;
                    int yend = y + 1;
                    if (x == 0) {
                        xstart = 0;
                    } else if (x == this.size - 1) {
                        xend = this.size - 1;
                    }
                    if (y == 0) {
                        ystart = 0;
                    } else if (y == this.size - 1) {
                        yend = this.size - 1;
                    }
                    for (int i = xstart; i <= xend; i++) {
                        for (int j = ystart; j <= yend; j++) {
                            if (this.hidden[i][j].equals(MINE) == true)
                                mines++;
                        }
                    }
                    this.open[x][y] = " " + mines + " ";
                }
            }
        }
    }

    private Move readNextMove() {
        boolean validInput = false;
        String x = null;
        String y = null;

        while (!validInput) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("enter x coordinate:");
            try {
                x = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Your choice for x was: " + x);

            System.out.println("enter y coordinate:");
            try {
                y = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Your choice for y was: " + y);

            validInput = validInput(x, y);
        }

        Move move = new Move(Integer.valueOf(x), Integer.valueOf(y));

        return move;
    }

    private boolean validInput(String x, String y) {
        boolean x_valid = false;
        boolean y_valid = false;

        if (x != null && !x.equals("") && Integer.valueOf(x) >= 0 && Integer.valueOf(x) <= this.size) {
            x_valid = true;
        }

        if (y != null && !y.equals("") && Integer.valueOf(y) >= 0 && Integer.valueOf(y) <= this.size) {
            y_valid = true;
        }
        return x_valid && y_valid;
    }

    public void print() {
        if (debug) {
            System.out.println("HIDDEN Minesweeper Field:");

            for (int x = 0; x < this.size; x++) {
                System.out.print(x + "\t|");
                for (int y = 0; y < this.size; y++) {
                    System.out.print("" + hidden[x][y] + "|");
                }
                System.out.println();
            }
        }

        System.out.println("\nHere is your open Minesweeper field:");

        // format line header
        printFormatLine();

        // index line header
        System.out.print("|  | 1");
        for (int s = 1; s < this.size; s++) {
            if (s < 9) {
                System.out.print(" | " + (s + 1));
            } else {
                System.out.print(" |" + (s + 1));
            }
        }
        if (this.size < 9) {
            System.out.println(" |");
        } else {
            System.out.println(" |");
        }

        // content
        for (int x = 0; x < this.size; x++) {
            if (x < 9) {
                System.out.print("| " + (x + 1));
            } else {
                System.out.print("|" + (x + 1));
            }
            //System.out.print("| " + (x+1));
            for (int y = 0; y < this.size; y++) {
                System.out.print("|" + open[x][y]);
            }
            System.out.println("|");
        }

        // format line header
        printFormatLine();
    }

    private void printFormatLine() {
        for (int s = 1; s < this.size; s++) {
            System.out.print("----");
        }
        System.out.println("--------");
    }


}
