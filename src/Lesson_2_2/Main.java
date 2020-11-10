package Lesson_2_2;

public class Main {
    public static void main(String[] args) {

        String[][] myArray = {
                {"10", "20", "20", "40"},
                {"4", "5", "20", "50"},
                {"40", "3", "6", "20"},
                {"30", "30", "23", "30"},
        };
        try {
            array(myArray);
        } catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }
        System.out.println("end");
    }

    static void array(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4) {
                throw new MyArraySizeException("Size Array[x!=4][]", arr);
            }
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Size Array[4][!=4]", arr);
            }
            for (int j = 0; j<arr[i].length; j++){
                if(!arr[i][j].matches("[-+]?\\d+")){
                    throw new MyArrayDataException("Ячейка ["+i+"]["+j+"] ("+arr[i][j]+") не является числом", arr[i][j]);
                }
                summ += Integer.parseInt(arr[i][j]);



            }
        }
        System.out.println(summ);

    }
}
