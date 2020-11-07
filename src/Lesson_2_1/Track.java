package Lesson_2_1;

public class Track implements Difficults{
    private String name;
    private int speed;

    public Track(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
