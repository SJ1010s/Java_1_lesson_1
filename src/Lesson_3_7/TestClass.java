package Lesson_3_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestClass {

    private static Method[] methodsBefore;
    private static Method[] methodsAfter;
    private static Method[] methodsTest;

    public static void start(String nameClass) {

        try {
            try {
                Method[] methods = Class.forName(nameClass).getDeclaredMethods();
           Method[] methodsSort = Arrays.stream(methods).filter((n) -> n.isAnnotationPresent(Test.class)).
                   sorted((n, m) -> n.getDeclaredAnnotation(Test.class).priory()).toArray(Method[]::new);
                check(methods);
                beforeSuite(methodsBefore);
                test(methodsTest);
                afterSuite(methodsAfter);

            } catch (IllegalAccessException | InvocationTargetException e) {


                e.printStackTrace();
                System.out.println("Метод не должен ничего принимать на вход");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Имя класса не верно");
        }
    }

    private static void check(Method[] methods){
        methodsBefore = Arrays.stream(methods).
                filter((n) -> n.isAnnotationPresent(BeforeSuite.class)).toArray(Method[]::new);
        methodsAfter = Arrays.stream(methods).
                filter((n) -> n.isAnnotationPresent(AfterSuite.class)).toArray(Method[]::new);
        methodsTest = Arrays.stream(methods).
                filter((n) -> n.isAnnotationPresent(Test.class)).sorted((o1, o2) -> o1.getDeclaredAnnotation(Test.class).priory()).toArray(Method[]::new);

        if (methodsBefore.length > 1 ){
            throw new RuntimeException("Число аннотаций BeforeSuite " +
                    "должно быть не больше 1");
        }
        if (methodsAfter.length > 1 ){
            throw new RuntimeException("Число аннотаций AfterSuite " +
                    "должно быть не больше 1");
        }
    }


    private static void test(Method[] methods) throws InvocationTargetException, IllegalAccessException {
        int priory = 1;
        while (true) {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    if (method.getAnnotation(Test.class).priory() == priory) {
                        method.invoke(null);
                    }
                    //                    System.out.println(method.getAnnotation(Test.class).priory());
                }
            }
            priory++;
            if (priory > 10) {
                break;
            }
        }
    }



    private static void beforeSuite(Method[] methods) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            method.invoke(null);
        }
    }

    private static void afterSuite(Method[] methods) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
                method.invoke(null);
        }
    }
}