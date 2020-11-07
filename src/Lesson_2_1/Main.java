package Lesson_2_1;

public class Main {
    public static void main(String[] args) {
        Runnable[] players = {
                new Cat("Pushok", 100, 100),
                new Cat("Murzik", 80, 110),
                new Man("Vasia", 70, 50),
                new Man("Sasha", 80, 60),
                new Robot("NK702", 40)
        };

        Jumpable[] playerJs = {
                new Cat("Pushok", 100, 100),
                new Cat("Murzik", 80, 110),
                new Man("Vasia", 70, 50),
                new Man("Sasha", 80, 60),
                new Robot("NK702", 40)
        };


        Wall[] walls = {
                new Wall("small wall", 30),
                new Wall("medium wall", 75),
                new Wall("big wall", 100),

        };

        Track[] tracks = {
                new Track("low track", 30),
                new Track("medium track", 75),
                new Track("big track", 95)
        };


        for (Runnable player : players) {
            for (Track track: tracks) {
                player.run(track);
                if (player.getSpeed()< track.getSpeed()){
                    break;
                }
            }
//            for (Wall wall: walls){
//                player.
//            }
        }

        for (Jumpable player: playerJs){
            for (Wall wall: walls){
                player.jump(wall);
                if (player.getJumping()<wall.getHeight()){
                    break;
                }
            }
        }

    }
}
