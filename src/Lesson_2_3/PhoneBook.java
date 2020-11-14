package Lesson_2_3;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    Map<String, Integer> book = new HashMap<>();

   public void add(String family, Integer phoneNumber){
       book.put(family, phoneNumber);
   }
   public void get(String family){
       System.out.println(family + " " + book.get(family));
   }

}
