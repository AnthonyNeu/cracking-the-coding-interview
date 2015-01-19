/*Question 14.6 Implement a Circular Array class that supports an array-like data structure which can be efficiently rotated.
The class should use a generic type, and should support iteration via the standard for (Obj o : circuLarArray) notation.
*/

public class Question {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int size = 10;
        CircularArray<String> array = new CircularArray<String>(size);
        for (int i = 0; i < size; i++) {
            array.set(i, String.valueOf(i));
        }

        array.rotate(3);
        for (int i = 0; i < size; i++) {
            System.out.println(array.get(i));
        }

        System.out.println("");

        array.rotate(2);
        for (String s : array) {
            System.out.println(s);
        }
    }

}
