package Geekbrains;

import java.util.Random;
import java.util.Scanner;


public class Lesson3_2 {
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);

    static int closedLetters = 15;
    static String introductionTxt = "Английское слово загадано, попытайтесь отгадать";
    static String winTxt = "Вы угадали слово";
    static String loseTxt = "Вы не угадали";
    static String guessTxt = "Буквы, которые вы угадали:";
    static String repeatTxt = "Попробуйте еще раз";
    static String theHiddenWord;
    static String userIn;

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                "potato"};
        int randomWord = random.nextInt(words.length);
        theHiddenWord = words[randomWord];

        //System.out.println(theHiddenWord);
        System.out.println(introductionTxt);
        guessTheWord();

    }

    static void guessTheWord() {
        userIn = sc.nextLine().toLowerCase();
        if (userIn.equalsIgnoreCase(theHiddenWord)) {
            System.out.println(winTxt);
        } else {
            System.out.println(loseTxt);
            System.out.println(guessTxt);
            letters();
            System.out.println(repeatTxt);
            guessTheWord();
        }
    }

    static int minLength(String usIn, String hid) {
        if (usIn.length() < hid.length()) {
            return usIn.length();
        } else {
            return hid.length();
        }
    }

    static void letters() {
        for (int i = 0; i < minLength(userIn, theHiddenWord); i++) {
            char letterHid = theHiddenWord.charAt(i);
            char letterIn = userIn.charAt(i);
            if (letterHid == letterIn) {
                System.out.print(letterHid);
            } else {
                System.out.print("#");
            }

        }
        for (int j=minLength(userIn, theHiddenWord); j<closedLetters; j++){
            System.out.print("#");
        }
        System.out.println();
    }

}
