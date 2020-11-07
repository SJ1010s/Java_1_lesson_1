package Lesson_2_1;

public class Robot implements Runnable, Jumpable{
    private String name;
    private int speed;
    private static int jumping = 0;

    public Robot(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public int getSpeed(){
        return speed;
    }

    @Override
    public int getJumping(){
        return jumping;
    }

    @Override
    public void run(Track a) {
        if (speed >=a.getSpeed()) {
            System.out.println("robot " + name + " run");
        } else {
            System.out.println("robot " + name + " don't run");
        }
    }

    @Override
    public void jump(Wall a) {
        System.out.println("Робот не умеет прыгать");
    }
}
