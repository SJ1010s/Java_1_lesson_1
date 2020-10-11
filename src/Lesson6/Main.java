package Lesson6;

import Lesson6.Animals.*;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = {
                new Cat("Барсик", 3),
                new Cat("Пушок", 5),
                new Dog("Бобик", 6),
                new Dog("Шарик", 4),
                new Dog("Ричард", 3)
        };

            animals[0].run(100);
            animals[0].run(300);
            animals[1].swim(9);
            animals[2].swim(9);
            animals[3].swim(20);

            animals[0].getCountOfAnimals();
            animals[0].getCountOfCat();
            animals[2].getCountOfDog();


    }
}
