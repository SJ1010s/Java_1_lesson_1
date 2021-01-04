package Lesson_3_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    // ================//
    private static CyclicBarrier cycBarrier = new CyclicBarrier(MainClass.CARS_COUNT);
    private static AtomicBoolean start = new AtomicBoolean(false);
    private static Lock lock = new ReentrantLock();
    private static AtomicBoolean finish = new AtomicBoolean(false);
    // =================//
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
    //============//
            cycBarrier.await();
           try {
               lock.lock();
               if (!start.get()) {
                   System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                   start.set(true);
               }
           } finally {
               lock.unlock();
           }

            cycBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
      //==============//
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        try {
            lock.lock();
            if(!finish.get()){
                System.out.println(this.name + " ПОБЕДИЛ!");
                finish.set(true);
            }
        } finally {
            lock.unlock();
        }
    }

    // ============//

//    public static boolean getStart(){
//        return start.get();
//    }
}
