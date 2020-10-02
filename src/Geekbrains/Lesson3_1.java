package Geekbrains;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Lesson3_1 {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static final String userInTxt = "Введите число от 0 до 9";
    static final String userNumberIsGreaterTxt = "Вы ввели число больше загаданного";
    static final String userNumberIsLessTxt = "Вы ввели число меньше загаданного";
    static final String userWin = "Вы победили";
    static final String userLose = "Вы проиграли";
    static final String userInRepeatTxt = "Желаете повторить игру?\nВведите 1 - Да; 0 - Нет.";

    static int randomNumber;
    static int tryCount = 3;

    public static void main(String[] args) {
        randomNumber = random.nextInt(10);
        System.out.println(randomNumber);
        //userIn();
        //guessNumber();
        startGame();

    }


    static int userIn() {
        int a;
        do {
            System.out.println(userInTxt);
            a = sc.nextInt();
        } while (a > 9 || a < 0);
        return a;
    }

    static int userInRepeat() {
        int a;
        do {
            System.out.println(userInRepeatTxt);
            a = sc.nextInt();
        } while (a > 1 || a < 0);
        return a;
    }

    static int guessNumber() {
        int userNumber = userIn();
        if (userNumber > randomNumber) {
            System.out.println(userNumberIsGreaterTxt);
        } else if (userNumber < randomNumber) {
            System.out.println(userNumberIsLessTxt);
        }
        return userNumber;
    }

    static void startGame(){
        for (int i = tryCount; i>0; i--){
            int a = guessNumber();
            if (a ==randomNumber){
                System.out.println(userWin);
                repeatGame();
                return;
            }
        }
        System.out.println(userLose);
        repeatGame();

    }

    static void repeatGame(){
        int a = userInRepeat();
        if (a == 1) {
            randomNumber = random.nextInt(10);
            startGame();
        }
    }

}
