package Lesson_3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> fruit;


    public Box(T ... fruit) {
        this.fruit = new ArrayList(Arrays.asList(fruit));
    }

    public List<T> getList(){
        return fruit;
    }
}
