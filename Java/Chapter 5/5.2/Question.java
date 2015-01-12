/* Question 5.3 Given a positive integer, print the next smallest and the next largest number that have the same number of 7bits in their binary representation.
 */

public class Question {
    public static String printBinary(double num)
    {
        if(num>=1 | num<=0)
            return "ERROR";

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while(num>0)
        {
            if(binary.length()>32)
                return "ERROR";

            double r = num *2;
            if(r>=1)
            {
                binary.append("1");
                num = r -1;
            }
            else
            {
                num = r;
            }
        }
        return binary.toString();
    }

    public static String printBinary2(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        double frac = 0.5;
        binary.append(".");
        while (num > 0) {
			/* Setting a limit on length: 32 characters */
            if (binary.length() >= 32) {
                return "ERROR";
            }
            if (num >= frac) {
                binary.append(1);
                num -= frac;
            } else {
                binary.append(0);
            }
            frac /= 2;
        }
        return binary.toString();
    }

    public static void main(String [] args){
        String bs = printBinary(.125);
        System.out.println(bs);

        for (int i = 0; i < 1000; i++) {
            double num = i / 1000.0;
            String binary = printBinary(num);
            if (!binary.equals("ERROR")) {
                System.out.println(num + " : " + binary);
            }
        }
    }
}


