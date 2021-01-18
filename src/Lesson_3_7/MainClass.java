package Lesson_3_7;

public class MainClass {

    public static void main(String[] args) {
        TestClass.start("Lesson_3_7.MainClass");
    }

    @BeforeSuite
    public static void testBefore(){
        System.out.println("Тест Before");
    }

//    @BeforeSuite
//    public static void testBefore2(){
//        System.out.println("Тест Before 2");
//    }

    @AfterSuite
    public static void testAfter(){
        System.out.println("Тест After");
    }

//    @AfterSuite
//    public static void testAfter2(){
//        System.out.println("Тест After 2");
//    }

    @Test(priory = 3)
    public static void test1(){
        System.out.println("Тестирование приоритет 3");
    }

    @Test(priory = 2)
    public static void test2(){
        System.out.println("Тестирование приоритет 2");
    }

    @Test(priory = 1)
    public static void test3(){
        System.out.println("Тестирование приоритет 1");
    }

    @Test(priory = 4)
    public static void test4(){
        System.out.println("Тестирование приоритет 4");
    }
}
