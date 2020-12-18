package Lesson_3_1;

public class Apple extends Fruit {
    private static final float weight = 1.0f;

    public Apple(String name) {
        super(name);
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
