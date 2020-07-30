import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class FindSubsets {
    public static void main(String[] args) {
        //initiated an array
        int[] array = {1, 2, 3};
        //initiated an arraylist to store all subsets
        ArrayList<HashSet> allSets = new ArrayList<>();

        //iterate to find all subsets
        for (int i = 0; i < Math.pow(2, array.length); i++) {
            //invented a new HashSet to store current subset
            //and renew the set when getting into a new iteration
            HashSet<Integer> subSet = new HashSet<>();

            //get to the subset
            for (int j = 0; j < array.length; j++) {
                //if the number is not in the present subset
                if ((i & (1 << j)) > 0) {
                    //add it
                    subSet.add(array[j]);
                }
             //after all addings, append the subset to the upper bag
            }allSets.add(subSet);


        System.out.println(allSets);
    }
}
}
