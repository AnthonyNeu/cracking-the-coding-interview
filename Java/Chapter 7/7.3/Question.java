/* Question 7.3 Given two lines on a Cartesian plane, determine whether the two lines would intersect.
 */

public class Question {
    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Line line1 = new Line(randomInt(5), randomInt(1));
            Line line2 = new Line(randomInt(5), randomInt(2));
            line1.print();
            System.out.print(", ");
            line2.print();
            if (line1.intersect(line2)) {
                System.out.println("  YES");
            } else {
                System.out.println("  NO");
            }
        }
    }

}