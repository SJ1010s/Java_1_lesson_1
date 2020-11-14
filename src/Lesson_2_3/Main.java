package Lesson_2_3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> word = new ArrayList<>(20);
        word.add("Vasia");
        word.add("Sashia");
        word.add("Vasia");
        word.add("Petia");
        word.add("Oleg");
        word.add("Victor");
        word.add("Vasia");
        word.add("Oleg");
        word.add("Vasia");
        word.add("Petia");
        word.add("Oleg");
        word.add("Vasia");
        word.add("Sergey");
        word.add("Evgeniy");
        word.add("Sashia");

        System.out.println(word);

        Set <String> wordSet = new HashSet<>(word);
        System.out.println(wordSet);

        Map <String, Integer> wordMap = new HashMap();

        for (String n: word){
            Integer count = wordMap.get(n);
            if (count == null){
                count = 1;
                wordMap.put(n, count);
            } else {
                count += 1;
                wordMap.put(n, count);
            }
        }

        System.out.println(wordMap);

        PhoneBook p = new PhoneBook();
        p.add("Semenov", 334509);
        p.add("Ivanov", 655542);
        p.add("Alekseev", 135567);
        p.add("Konovalov", 543326);
        p.add("Petrov", 665533);
        p.add("Volkov", 223567);

        p.get("Konovalov");





    }
}
