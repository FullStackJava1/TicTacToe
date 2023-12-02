import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int row;
        int col;
        int trn = 1;
        int win = 0; //1 win 2 Game over
        String user = "A";

        String[][] gui = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};
        for (String c[] : gui) {
            for (String el : c) {
                System.out.print(" " + el + " ");
            }
            System.out.println();
        }
        System.out.println(" ____________ ");
        System.out.println("|  User X    |");
        System.out.println("|  User O    |");
        System.out.println("|____________|");

        System.out.println("\nGame is Begenning...\n");
        //guiTicTacToe();
        //X is start

        while (win == 0) {
            if (trn % 2 != 0) {
                user = "X";
                System.out.println("X's turn.... ");
            } else {
                user = "O";
                System.out.println("O's turn.... ");
            }
            trn++;
            row = insertRowFormUser();
            System.out.println(row);
            col = insertColFormUser();
            System.out.println(col);
            updateArray(gui, row, col, user);
            for (String c[] : gui) {
                for (String el : c) {
                    System.out.print(" " + el + " ");
                }
                System.out.println();
            }
            win = checkGameOver(gui, win);
            if (win == 2) {
                break;

            }
            win = checkWin(gui, win);

        }

    }

    public static int insertRowFormUser() {
        int row = 0;
        do {
            System.out.println("Enter num 0-2 for to row");
            row = scanner.nextInt();
        } while (row < 0 || row > 2); //check that the number you chaose is not out of rang
        return row;
    }

    public static int insertColFormUser() {
        int col = 0;
        do {
            System.out.println("Enter num 0-2 for to Col");
            col = scanner.nextInt();

        } while (col > 2 || col < 0);//check that the number you chaose is not out of rang


        return col;
    }

    static void updateArray(String[][] arr, int i, int j, String user) {
        if (user == "X") {
            if (arr[i][j] == "_") {
                arr[i][j] = "X";
            } else {
                System.out.println("already exsited " + arr[i][j] + " Try again!!");

            }

        } else if (user == "O") {
            if (arr[i][j] == "_") {
                arr[i][j] = "O";
            } else {
                System.out.println("already exsited " + arr[i][j] + " Try again!!");

            }
        }

    }

    public static int checkGameOver(String arr[][], int win) {
        int count = 0;
        for (String s[] : arr) {
            for (String el : s) {
                if (el == "X" || el == "O") {
                    count++;
                }
            }
        }
        if (count == 9) {
            win = 2;
            System.out.println("Game Over");

        }
        return win;

    }

    public static int checkWin(String arr[][], int win) {
        //option to win
        int countXi0 = 0, countXi1 = 0, countXi2 = 0;
        int countOiO = 0, countOi1 = 0, countOi2 = 0;
        int countXj0 = 0, countXj1 = 0, countXj2 = 0;
        int countOjO = 0, countOj1 = 0, countOj2 = 0;
        int countXi_j = 0, countOi_j = 0;
        int _DiagonalX = 0, _DiagonalO = 0;

        //loop chacke condtion to Win
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    if (arr[i][j] == "X") {
                        countXi_j++;
                    } else if (arr[i][j] == "O") {
                        countOi_j++;
                    }
                } else if (i == 0) {
                    if (arr[i][j] == "X") {
                        countXi0++;
                    } else if (arr[i][j] == "O") {
                        countOiO++;
                    }

                } else if (j == 0) {
                    if (arr[i][j] == "X") {
                        countXj0++;
                    } else if (arr[i][j] == "O") {
                        countOjO++;
                    }

                } else if (i == 1) {
                    if (arr[i][j] == "X") {
                        countXi1++;
                    } else if (arr[i][j] == "O") {
                        countOi1++;
                    }

                } else if (j == 1) {
                    if (arr[i][j] == "X") {
                        countXj1++;
                    } else if (arr[i][j] == "O") {
                        countOj1++;
                    }

                } else if (i == 2) {
                    if (arr[i][j] == "X") {
                        countXi2++;
                    } else if (arr[i][j] == "O") {
                        countOi2++;
                    }

                } else if (j == 2) {
                    if (arr[i][j] == "X") {
                        countXj2++;
                    } else if (arr[i][j] == "O") {
                        countOj2++;
                    }
                } else if ((j == (arr.length - 1) && i == 0) || (i == 2 && j == 0) || (i == (arr.length / 2) && j == (arr.length / 2))) {
                    if (arr[i][j] == "X") {
                        _DiagonalX++;
                        System.out.println(_DiagonalX);
                    } else if (arr[i][j] == "O") {
                        _DiagonalO++;
                        System.out.println(_DiagonalO);
                    }
                }
            }


        }

        if (countXi0 == 3 || countXi1 == 3 || countXi2 == 3 || countXj0 == 3 || countXj1 == 3 || countXj2 == 3 || countXi_j == 3) {
            win = 1;
            System.out.println("User X is Winnnn");

        } else if (countOiO == 3 || countOi1 == 3 || countOi2 == 3 || countOjO == 3 || countOj1 == 3 || countOj2 == 3 || countOi_j == 3) {
            win = 1;
            System.out.println("User O is Winnnn");
        }
        return win;

    }
}