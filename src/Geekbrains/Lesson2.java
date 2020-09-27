package Geekbrains;

public class Lesson2 {


    public static void main(String[] args) {

        printArray(invertArray());
        printArray(createArray3(8));
        printArray(arrayx2());
        printArray2D(array2Dx1());
        arrayMaxMin();
        int[] arrLR = {2, 3, 4, 1};
        System.out.println(arrayLeftRight(arrLR));
        int[] setArray = {1, 2, 3, 4, 5};
        arrayOffsetN(-6, setArray);
    }

    static int[] invertArray() {
        int[] arr = {1, 0, 1, 0, 0, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
        }
        return arr;
    }

    static int[] createArray3(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        return arr;
    }

    static int[] arrayx2() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 6) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    static int[][] array2Dx1() {
        int[][] arr2D = new int[10][10];
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (i == j || (i + j == (arr2D.length - 1))) {
                    arr2D[i][j] = 1;
                }
            }
        }
        return arr2D;
    }

    static void arrayMaxMin() {
        int[] arr = {4, 2, 10, 3, 5, 6, 8};
        int maxArr, minArr;
        maxArr = arr[0];
        minArr = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxArr < arr[i]) {
                maxArr = arr[i];
            }
            if (minArr > arr[i]) {
                minArr = arr[i];
            }
        }
        System.out.println("max = " + maxArr + "; min = " + minArr);
    }

    static boolean arrayLeftRight(int[] arr) {
        int sumLeft = 0;
        boolean ret = false;
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            int sumRight = 0;
            for (int j = (arr.length - 1); j > i; j--) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                ret = true;
            }

        }
        return ret;
    }

    /**
     * Этот метод выводит на экран массив со сдвинутыми на шаг n элементами
     *
     * @param n шаг сдвига массива
     * @param arr одномерный массив
     * */
    static void arrayOffsetN(int n, int[] arr) {
        int nPlus = arr.length - n%arr.length;
        for (int i = 0; i < arr.length; i++) {
            int offsetPlus = Math.abs((i + nPlus) % (arr.length));
            int offsetMinus = (i + Math.abs(n)) % (arr.length);
            if (n >= 0) {
                System.out.printf("%5d", arr[offsetPlus]);
            } else if (n < 0) {
                System.out.printf("%5d", arr[offsetMinus]);
            }
        }
    }

    /**
     * Этот метод распечатывает одномерный массив
     *
     * @param arr массив
     */
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%5d", arr[i]);
        }
        System.out.println();
    }


    /**
     * Этот метот распечатывает двумерный массив
     *
     * @param arr массив
     */
    static void printArray2D(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
