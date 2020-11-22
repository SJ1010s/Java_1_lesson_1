package Lesson_2_5;

public class MyArrayClass {
    static final int SIZE = 10000000;
    static final int h = SIZE/2;
    float[] arr = new float[SIZE];

    public void myArray1() {
        for (float n:arr){
            n = 1f;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i<arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long b = System.currentTimeMillis();
        System.out.println("array_1 = " + (b - a));

    }

    public void myArray2() {
        for (float n:arr){
            n = 1f;
        }
        long a = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1,0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread array1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread array2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        array1.start();
        array2.start();

        try {
            array1.join();
            array2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        long b = System.currentTimeMillis();
        System.out.println("array_2 = " + (b - a));
    }
}
