package Lesson5;

public class Lesson5_Main {
    public static void main(String[] args) {
//        Worker Petrov = new Worker();
//        Petrov.info();

        Worker[] workers = new Worker[5];
        workers[0] = new Worker("Ivanov Ivan Ivanovich", "Meneger", "ivanov@mail.ru",
                "+79349349349", 70340, 41);
        workers[1] = new Worker("Dobrinin Sergey Andreevich", "Driver", "dobr@mail.ru",
                "+79230930304", 90930, 52);
        workers[2] = new Worker("Vekman Oleg Sergeevich", "Meneger", "vekman@mail.ru",
                "+79609900000", 90930, 23);
        workers[3] = new Worker("Rumiancev Vasilii Vasilievich", "Driver", "rum@mail.ru",
                "+79490930204", 90930, 60);
        workers[4] = new Worker("Vilman", "Meneger", "vilman@mail.ru",
                "+79340983345", 90930, 32);


        for (int i = 0; i< workers.length; i++){
            if(workers[i].getAge()>40) {
                workers[i].info();
            }
        }
    }

}
