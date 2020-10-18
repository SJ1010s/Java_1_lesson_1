package CodeWars;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String morse = ".... . -.--     .--- ..- -.. .";

        String[] word = getWord(morse);
        String[][] letters = getLetters(word);

        String decodeText = "";
        for (int i = 0; i<letters.length;i++){
            for (int j = 0; j<letters[i].length; j++){
                decodeText = decodeText.concat(letters[i][j]);
            }
        }
        System.out.println(letters.length);
        printArray2(letters);
//

    }

    public static String[] getWord(String morse){
        String[] word = morse.split("   ");
        for (int i = 0; i < word.length; i++) {
            word[i] = word[i].trim();
        }
        return word;
    }

    public static String[][] getLetters(String[] word){
        String[][] letters = new String[word.length][];
        for (int i = 0; i < word.length; i++) {
            letters[i] = word[i].split(" ");
        }
        return letters;
    }

    public static void printArray2(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%10s", arr[i][j]);
            }
            System.out.println();
        }
    }
}