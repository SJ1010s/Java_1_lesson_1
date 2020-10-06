package Geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Вы победитель!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Комьютер победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }


    static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Input coord X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        //       map[y][x] = DOT_O;
        aiTurnBlock(y, x);
    }

    static void aiTurnBlock(int y, int x) {
        int yMaxBlock = y;
        int xMaxBlock = x;
        int maxAiBlockPotential = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // Проверяет потенциальную блокировку ячеек только у пустых ячеек
                if (isCellValid(i, j)) {
                    if (aiBlockPotential(i, j) > maxAiBlockPotential) {
                        maxAiBlockPotential = aiBlockPotential(i, j);
                        yMaxBlock = i;
                        xMaxBlock = j;
                    }


                }
            }
        }
        map[yMaxBlock][xMaxBlock] = DOT_O;
    }

    // Возвращает потенциал блокировки для координаты
    static int aiBlockPotential(int y, int x) {
        int blockPotential = 0;
        int countY = 0;
        int countX = 0;
        int yy = y;
        int xx = x;
        int yyM = y;
        int xxM = x;
        int countXY = 0;
        int countYX = 0;
        int a = 0;
        while (a < DOTS_TO_WIN) {
            yy++;
            xx++;
            yyM--;
            xxM--;
            // Ветка Х и У положительная и отрицательная.


            if (xx < SIZE) {
                if (map[y][xx] == DOT_X) {
                    countX++;
                }
            }
            if (yy < SIZE) {
                if (map[yy][x] == DOT_X) {
                    countY++;
                }
            }

            if (xxM >= 0) {
                if (map[y][xxM] == DOT_X) {
                    countX++;
                }
            }
            if (yyM >= 0) {
                if (map[yyM][x] == DOT_X) {
                    countY++;
                }
            }

            // Ветка диагональная положительная и отрицательная
            if (yy < SIZE && xx < SIZE) {
                if (map[yy][xx] == DOT_X) {
                    countXY++;
                }
            }
            if (yyM >= 0 && xxM >= 0) {
                if (map[yyM][xxM] == DOT_X) {
                    countXY++;
                }
            }
            if (yy < SIZE && xxM >= 0) {
                if (map[yy][xxM] == DOT_X) {
                    countYX++;
                }
            }
            if (yyM >= 0 && xx < SIZE) {
                if (map[yyM][xx] == DOT_X) {
                    countYX++;
                }
            }
            a++;


        }
        if (blockPotential < countY) {
            blockPotential = countY;
        }
        if (blockPotential < countX) {
            blockPotential = countX;
        }
        if (blockPotential < countXY) {
            blockPotential = countXY;
        }
        if (blockPotential < countYX) {
            blockPotential = countYX;
        }
        return blockPotential;
    }

    // Возвращает победный потенциал для координаты
    static void aiWinPotential(int y, int x) {

    }


    static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(char c) {
//        if (map[0][0] == c && map[0][1] == c && map[0][2] == c) { return true; }
//        if (map[1][0] == c && map[1][1] == c && map[1][2] == c) { return true; }
//        if (map[2][0] == c && map[2][1] == c && map[2][2] == c) { return true; }
//
//        if (map[0][0] == c && map[1][0] == c && map[2][0] == c) { return true; }
//        if (map[0][1] == c && map[1][1] == c && map[2][1] == c) { return true; }
//        if (map[0][2] == c && map[1][2] == c && map[2][2] == c) { return true; }
//
//        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) { return true; }
//        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) { return true; }


        for (int i = 0; i < SIZE; i++) {
            int countXY = 0;
            int countXY2 = 0;
            int countYX = 0;
            int countYX2 = 0;
            int countX = 0;
            int countY = 0;

            if (map[i][i] == c) {
                countXY++;
            }
            if (map[i][SIZE - 1 - i] == c) {
                countYX++;
            }
            int XY = i;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == c) {
                    countX++;
//                    if (countX < DOTS_TO_WIN && map[i][j] == DOT_EMPTY) {
//                        countX = 0;
//                    }
                }
                if (map[j][i] == c) {
                    countY++;
//                    if (countY < DOTS_TO_WIN && map[j][i] == DOT_EMPTY){
//                        countY = 0;
//                    }
                }
                if (XY < SIZE) {
                    if (map[XY][j] == c) {
                        countXY++;
                    }
                    if (map[j][XY] == c) {
                        countXY2++;
                    }
                }
                if (XY < SIZE && (SIZE - 1 - XY) >= 0) {
                    if (map[SIZE - 1 - XY][j] == c) {
                        countYX++;
                    }
                    if (map[j][SIZE - 1 - XY] == c) {
                        countYX2++;
                    }
                }
                XY++;
            }
            if (countX == DOTS_TO_WIN || countY == DOTS_TO_WIN || countXY == DOTS_TO_WIN
                    || countYX == DOTS_TO_WIN || countXY2 == DOTS_TO_WIN || countYX2 == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

}
