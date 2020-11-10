package Lesson_2_2;

public class MyArraySizeException extends IllegalArgumentException {
    String[][] array;

    public MyArraySizeException(String[][] array) {
        this.array = array;
    }

    public MyArraySizeException(String s, String[][] array) {
        super(s);
        this.array = array;
    }

    public void printArray(){
        for (String[] i :array) {
            for (String j : i) {
                System.out.printf("%5s", j);
            }
            System.out.println();
        }
    }

    public String[][] getArray() {
        return array;
    }
}

