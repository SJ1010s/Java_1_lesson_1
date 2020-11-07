package Lesson_2_1;

public class Cat implements Runnable, Jumpable {
    private String name;
    private int speed;
    private int jumping;

    public Cat(String name, int speed, int jumping) {
        this.name = name;
        this.speed = speed;
        this.jumping = jumping;
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
            System.out.println("cat " + name + " run");
        } else {
            System.out.println("cat " + name + " don't run");
        }
    }

    @Override
    public void jump(Wall a) {
        if (jumping >= a.getHeight()) {
            System.out.println("cat " + name + " jump");
        } else {
            System.out.println("cat " + name + " don't jump");
        }
    }
}
