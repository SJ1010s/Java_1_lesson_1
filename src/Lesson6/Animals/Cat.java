package Lesson6.Animals;

public class Cat extends Animal {
    static int countOfCat = 0;

    public Cat(String name, int age) {
        super(name, age);
        countOfCat++;
    }

    @Override
    public void run(int length) {
        int runLength = 200;
        if (length <= runLength) {
            System.out.println(name + " пробежал " + length + " м");
        } else {
            System.out.println("Кот не бегает так далеко");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кот не умеет плавать");
    }

    @Override
    public void getCountOfCat(){
        System.out.println("Вы создали " + countOfCat + " котов");
    }
}
