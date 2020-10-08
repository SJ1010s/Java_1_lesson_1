package Lesson5;

public class Worker {
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;


    public Worker() {
        this("Петров Василий Михайлович", "Инженер", "petrov@mail.ru",
                "+79690989832", 60500, 30);
    }

    public Worker(String FIO, String position, String email, String phone, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void info(){
        System.out.printf("Сотрудник %s %s %s %s %d %d\n", FIO, position, email, phone, salary, age);
    }
    public int getAge(){
        return age;
    }
}
