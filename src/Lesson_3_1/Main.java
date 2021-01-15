package Lesson_3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BoxArr<String> Box1 = new BoxArr<>("Cat", "Dog", "Dug", "Fish");
        System.out.println(Arrays.asList(Box1.getSwapArr(0, 3)));

        String[] array = {"Fruit", "Dog", "Print", "Fish"};
        System.out.println(arrayList(array));

        Fruit apple1 = new Apple("apple1");
        Fruit apple2 = new Apple("apple2");
        Fruit apple3 = new Apple("apple3");
        Fruit apple4 = new Apple("apple4");
        Fruit orange1 = new Orange("orange1");
        Fruit orange2 = new Orange("orange2");
        Fruit orange3 = new Orange("orange3");



//        Box<Apple> BoxApple = new Box<Apple>(apple1, apple2, apple3, apple4);

    }
    public static <T> List<T> arrayList(T [] arr){
        List<T> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }
        return arrList;
    }

}
