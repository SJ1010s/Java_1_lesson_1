package Lesson_2_2;

public class MyArrayDataException extends NumberFormatException{
    String numberFormat;

    public MyArrayDataException(String numberFormat) {
        this.numberFormat = numberFormat;
    }

    public MyArrayDataException(String s, String numberFormat) {
        super(s);
        this.numberFormat = numberFormat;
    }
}
