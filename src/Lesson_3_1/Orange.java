package Lesson_3_1;

public class Orange extends Fruit{
    private static final float weight = 1.5f;

    public Orange(String name) {
        super(name);
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
