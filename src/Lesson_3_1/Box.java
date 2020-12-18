package Lesson_3_1;

import java.util.ArrayList;

public class Box implements Comparable<Box> {
    private Apple apple;


    public Box(Apple apple) {
        this.apple = apple;
    }

    @Override
    public int compareTo(Box o) {
        return 0;
    }
}
