package Lesson_3_1;

public class BoxArr<T> {
    private T[] arr;

    public BoxArr(T ... arr) {
        this.arr = arr;
    }

    public T[] getSwapArr(int numberOne, int numberTwo){
        T element;
        element = arr[numberOne];
        arr[numberOne]=arr[numberTwo];
        arr[numberTwo]=element;
        return arr;
    }
}
