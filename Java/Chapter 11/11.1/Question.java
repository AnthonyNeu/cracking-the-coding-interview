/*Question 11.1 You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
Write a method to merge B into A in sorted order.
 */

import MyLibrary.AssortedMethod;

public class Question {
    /** Merges array
     * @param a first array
     * @param b second array
     * @param lastA number of "real" elements in a
     * @param lastB number of "real" elements in b
     */
    public static void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
        int indexA = lastA - 1; /* Index of last element in array b */
        int indexB = lastB - 1; /* Index of last element in array a */

        /* Merge A and B, start from the end of the array.*/
        while(indexB>=0)
        {
            if(indexA>=0 && a[indexA] >= b[indexB])
            {
                a[indexMerged] = a[indexA];
                indexA--;
            }
            else
            {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 7, 6, 7, 7};
        merge(a, b, 8, b.length);
        System.out.println(AssortedMethod.arrayToString(a));
    }
}
