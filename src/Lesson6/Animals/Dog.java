package Lesson6.Animals;

public class Dog extends Animal {
    static int countOfDog = 0;

    public Dog(String name, int age) {
        super(name, age);
        countOfDog++;
    }

    @Override
    public void run(int length) {
        int runLength = 500;
        if (length <= runLength) {
            System.out.println(name + " пробежал " + length + " м");
        } else {
            System.out.println("Собака не бегает так далеко");
        }
    }

    @Override
    public void swim(int length) {
        int swimLength = 10;
        if (length <= swimLength) {
            System.out.println(name + " проплыл " + length + " м");
        } else {
            System.out.println("Собака не плавает так далеко");
        }
    }

    @Override
    public void getCountOfDog() {
        System.out.println("Вы создали " + countOfDog + " собак");
    }
}
