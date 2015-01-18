/*Question 11.3 Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array.
You may assume that the array was originally sorted in increasing order.*/


public class Question {
    public static int search(int[] a, int x, int low, int high) {
        int mid = (low + high) / 2;

        if (x == a[mid])
            return mid;

        if (low > high)
            return -1;

        //we need to find the normally ordered part of the array and do binary search to find the elements
        if (a[low] < a[mid])//left is normally ordered
        {
            if (x >= a[low] && x <= a[mid])
                search(a, x, low, mid - 1);
            else
                search(a, x, mid, high);
        } else if (a[high] > a[mid])//right is normally ordered
        {
            if (x <= a[high] && x >= a[mid])
                search(a, x, mid + 1, high);
            else
                search(a, x, low, mid-1);
        } else if (a[low] == a[mid])//left is not normally ordered,
        {
            if (a[high] == a[mid])//left half equal to a[mid]
            {
                int result = search(a, x, low, mid-1);
                if (result == -1)
                    return search(a, x, mid + 1, high);
                else
                    return result;
            } else//left half is not equal to a[mid]
            {
                return search(a, x, mid + 1, high);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = { 2, 3, 2, 2, 2, 2, 2, 2 , 2 , 2 };

        System.out.println(search(a, 2, 0, a.length - 1));
        System.out.println(search(a, 3, 0, a.length - 1));
        System.out.println(search(a, 4, 0, a.length - 1));
        System.out.println(search(a, 1, 0, a.length - 1));
        System.out.println(search(a, 8, 0, a.length - 1));
    }
}
