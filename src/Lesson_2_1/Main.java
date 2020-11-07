package Lesson_2_1;

public class Main {
    public static void main(String[] args) {
        Players[] players = {
                new Cat("Pushok", 100, 100),
                new Cat("Murzik", 80, 110),
                new Man("Vasia", 70, 50),
                new Man("Sasha", 80, 60),
                new Robot("NK702", 40)
        };

        Difficults[] difficults = {
                new Wall("small wall", 30),
                new Track("low track", 30),
                new Wall("medium wall", 75),
                new Track("medium track", 75),
                new Wall("big wall", 100),
                new Track("big track", 95)
        };


        for (Players player : players) {
            for (Difficults difficulty: difficults) {
                if (difficulty instanceof Wall) {
                    player.jump((Wall) difficulty);
                    if (player.getJumping() < difficulty.getHeight()) {
                        break;
                    }
                } else if (difficulty instanceof Track) {
                    player.run((Track) difficulty);
                    if (player.getSpeed() < difficulty.getSpeed()){
                        break;
                    }
                }

            }
        }


    }
}
