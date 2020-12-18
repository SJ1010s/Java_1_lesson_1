package Lesson_3_1;

public abstract class Fruit {
    String name;

    public Fruit(String name) {
        this.name = name;
    }

    public abstract float getWeight();
}
