/* Question 9.4 Write a method to return all subsets of a set.*/

/*
Answer: we can use recursion to solve this. Once we get the subset of previous i elements of the set, we add one new item to the all subset
of the previous subset, and add these subsets to the result set.
 */

import java.util.*;

public class Question {
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if(set.size() == index)
        {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        }
        else
        {
            allsubsets = getSubsets(set,index+1);
            int maxitem = set.get(index);
            ArrayList<ArrayList<Integer>> tempsubset = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset : allsubsets)
            {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(maxitem);
                tempsubset.add(newsubset);
            }
            allsubsets.addAll(tempsubset);
        }
        return allsubsets;
    }

    public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    //this is the brute-force way to compuet the subset
    public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size(); /* Compute 2^n */
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allsubsets.add(subset);
        }
        return allsubsets;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
        System.out.println(subsets.toString());

        ArrayList<ArrayList<Integer>> subsets2 = getSubsets2(list);
        System.out.println(subsets2.toString());
    }
}