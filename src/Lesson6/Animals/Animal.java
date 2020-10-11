package Lesson6.Animals;

public abstract class Animal {
    String name;
    int age;
    static int countOfAnimals = 0;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        countOfAnimals++;
    }

    public abstract void run(int length);
    public abstract void swim(int length);

    public void getCountOfAnimals(){
        System.out.println("Вы создали " + countOfAnimals + " животных");
    }

    public void getCountOfCat(){

    }
    public void getCountOfDog(){

    }
}
