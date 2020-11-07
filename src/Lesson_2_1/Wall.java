package Lesson_2_1;

public class Wall implements Difficults {

    private String name;
    private int height;

    public Wall(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
