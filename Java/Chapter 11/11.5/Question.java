/*Question 11.5 Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.*/


/*
Answer: We simply modify the binary search to fit into this situation. If the string in the mid is empty string, we find the right of the position until we find
the first non-empty string.
 */

public class Question {
    public static int searchI(String[] strings, String str, int first, int last) {
        while (first <= last) {
			/* Move mid to the middle */
            int mid = (last + first) / 2;

			/* If mid is empty, find closest non-empty string */
            if (strings[mid].isEmpty()) {
                int left = mid - 1;
                int right = mid + 1;
                while (true) {
                    if (left < first && right > last) {
                        return -1;
                    } else if (right <= last && !strings[right].isEmpty()) {
                        mid = right;
                        break;
                    } else if (left >= first && !strings[left].isEmpty()) {
                        mid = left;
                        break;
                    }
                    right++;
                    left--;
                }
            }

            int res = strings[mid].compareTo(str);
            if (res == 0) { // Found it!
                return mid;
            } else if (res < 0) { // Search right
                first = mid + 1;
            } else { // Search left
                last = mid - 1;
            }
        }
        return -1;
    }

    public static int searchR(String[] strings, String str, int first, int last) {
        if (first > last) {
            return -1;
        }

		/* Move mid to the middle */
        int mid = (last + first) / 2;
        int temp = mid;

		/* If mid is empty, find rightmost non-empty string */
        while(strings[temp].isEmpty() && temp <= last)
            temp++;

        if(temp > last)
        {
            last = mid -1;
            return searchR(strings,str,first,last);
        }
        else {
            if (strings[temp].equals(str))
                return temp;
            else if (strings[temp].compareTo(str) < 0)
                return searchR(strings, str, temp + 1, last);
            else
                return searchR(strings, str, first, temp - 1);
        }
    }

    public static int search(String[] strings, String str) {
        if (strings == null || str == null || str.isEmpty()) {
            return -1;
        }
        return searchR(strings, str, 0, strings.length - 1);
    }

    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "ac"));

        for (String s : stringList) {
        	String cloned = new String(s);
        	System.out.println("<" + cloned + "> " + " appears at location " + search(stringList, cloned));
        }
    }
}
