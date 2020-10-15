package Lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (amount < 0) {
            return;
        }
        food -= amount;
    }

    public void foodInPlate(int foodIn) {
        if (foodIn > 0 && foodIn <= 20) {
            food = foodIn;
            System.out.println("Тарелка пополнена на " + foodIn + " еды");
        } else {
            System.out.println("В тарелку помещается от 0 до 20 еды");
        }
    }

//
//    @Override
//    public String toString() {
//        return "Plate{" +
//                "food=" + food +
//                '}';
//    }

}
