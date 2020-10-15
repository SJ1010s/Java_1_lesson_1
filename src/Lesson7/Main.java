package Lesson7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Pushok"),
                new Cat("Snezhok"),
                new Cat("Murzik")
        };
        Plate food = new Plate(20);
        cats[0].eat(food);
        cats[0].eat(food);
        cats[1].eat(food);
        cats[2].eat(food);

        for (int i =0; i<cats.length; i++){
            cats[i].getSatiety();
        }
        food.foodInPlate(20);
    }
}
