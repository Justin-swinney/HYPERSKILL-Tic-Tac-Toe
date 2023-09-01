

import java.util.Scanner;

public class TicTacToe {
    private char[][] gameGrid;
    private char player;
    private char player1;
    private boolean endGame;
    private boolean x;
    private boolean o;

    public TicTacToe() {
        gameGrid = new char[3][3];
        player = 'X';
        player1 = 'O';
        endGame = false;
        x = false;
        o = false;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        String input =" ";
        int row, col;
        int turn = 0;

        startingBoard(input);

        while(!endGame) {
            printBoard();
            gameStatus();
            System.out.print("> ");
            try {
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;


                if (isValidCord(row, col)) {
                    if (isValidInput(row, col)) {

                        if (turn % 2 == 0) {
                            inputMoveX(row, col);
                            player = (player == 'X') ? 'X' : 'O';
                        }
                        else if (turn % 2 == 1) {
                            inputMoveO(row, col);
                            player1 = (player1 == 'O') ? 'O' : 'X';
                        }
                        ++turn;
                    }
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
                else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }
            catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
            gameStatus();

        }

    }
    public void startingBoard(String input) {
        int charIndex = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (charIndex < input.length()) {
                    gameGrid[i][j] = input.charAt(charIndex);
                    charIndex++;
                } else {
                    gameGrid[i][j] = ' ';
                }
            }

        }
    }

    private void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(gameGrid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private boolean isValidCord(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    private boolean isValidInput(int row, int col) {
        return gameGrid[row][col] == ' ';
    }
    private void inputMoveX(int row, int col) {
        gameGrid[row][col] = player;
    }
    private  void inputMoveO(int row, int col) {
        gameGrid[row][col] = player1;
    }

    private boolean checkWinner() {
        for (int i = 0; i < gameGrid.length;) {
            if (gameGrid[i][0] == 'X' && gameGrid[i][1] == 'X' && gameGrid[i][2] == 'X') {
                x = true;
                return true;
            }
            if (gameGrid[0][i] == 'X' && gameGrid[1][i] == 'X' && gameGrid[2][i] == 'X') {
                x = true;
                return true;
            }
            if (gameGrid[0][0] == 'X' && gameGrid[1][1] =='X' && gameGrid[2][2] == 'X') {
                x = true;
                return true;
            }
            if (gameGrid[0][2] == 'X' && gameGrid[1][1] == 'X' && gameGrid[2][1] == 'X') {
                x = true;
                return true;
            }
            ++i;
        }
        for (int j = 0; j < gameGrid.length;) {
            if (gameGrid[j][0] == 'O' && gameGrid[j][1] == 'O' && gameGrid[j][2] == 'O') {
                o = true;
                return true;
            }

            if (gameGrid[0][j] == 'O' && gameGrid[1][j] == 'O' && gameGrid[2][j] == 'O') {
                o = true;
                return true;
            }
            if (gameGrid[0][0] == 'O' && gameGrid[1][1] =='O' && gameGrid[2][2] == 'O') {
                o = true;
                return true;
            }
            if (gameGrid[0][2] == 'O' && gameGrid[1][1] == 'O' && gameGrid[2][1] == 'O') {
                o = true;
                return true;
            }
            ++j;
        }

        return false;
    }

    public void gameStatus() {
        if (checkWinner()) {
            printBoard();
            results();
            endGame = true;
        }
    }
    public void results() {
        if (checkWinner()) {
            if (x) {
                System.out.println(player + " wins");
            }
            if (o) {
                System.out.println(player1 + " wins");
            }
        }
    }



    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();

    }

}
