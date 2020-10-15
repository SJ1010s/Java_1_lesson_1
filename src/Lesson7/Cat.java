package Lesson7;

public class Cat {

    private String name;
    private int catEat = 10;
    private boolean satiety = false;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void getSatiety(){
        if (satiety) {
            System.out.println("Cat " + name + " is full");
        } else System.out.println("Cat " + name + " hungry");
    }

    public void eat(Plate plate) {
        if (satiety){
            System.out.println("Cat "+ name + " is full");
            return;
        }
        if (plate.getFood()>=catEat) {
            System.out.println("Cat " + name + " eat...");
            plate.decreaseFood(catEat);
            satiety = true;
        } else {
            System.out.println("Cat " + name + " Not food");
        }
    }


}
