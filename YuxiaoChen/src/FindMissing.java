import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindMissing {
    static void printMissing(int[] a){
        //initiate an arraylist to save our final result
        ArrayList<Integer> lost = new ArrayList<Integer>();
        //loop through the modified array
        for (int i = 1; i < a.length; i++){
            //check if the elements are consecutive
            // if not, add the missing number into the array list
            if(a[i] - a[i-1] != 1){
                lost.add(a[i]-1);
            }
        }
        //print out the results
        for (int i : lost){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        //initiate an array with all consecutive numbers
        Scanner in = new Scanner(System.in);

        //default value for start and end positions
        int startPosition = 1;
        int endPosition = 100;

        //get the first element
        System.out.print("Enter the number you want to start with : ");
        try {
            startPosition = in.nextInt();
        }
        //exit the program if meeting improper input
        catch (java.util.InputMismatchException e) {
            System.exit(0);
        }

        //get last element
        System.out.print("Enter the number you want to end with improper input would terminate the program: ");
        try {
            endPosition = in.nextInt();
            if (endPosition<startPosition){
                System.exit(0);
            }
        }
        catch (java.util.InputMismatchException e) {
            System.exit(0);
        }
        //started a new array for all consecutive numbers
        int[] full = IntStream.range(startPosition, endPosition+1).toArray();
        //invented an arraylist for deleted numbers
        ArrayList<Integer> deleted = new ArrayList<Integer>();

        int entered = 0;
        //iteratively get numbers to be deleted
        while(true){
            System.out.print("Enter the number you want to delete(enter 0 to exit) improper input would terminate the program: ");
            try {
                entered = in.nextInt();
                if (entered == 0||entered>endPosition||entered<startPosition)
                    break;
                deleted.add(entered);
            }
            catch (java.util.InputMismatchException e) {
                System.exit(0);
            }


        }

        //loop through the array and remove 3,10,20 as required
        for(int i = 0; i < full.length; i++){
            if(deleted.contains(full[i])){
                for(int j = i; j < full.length - 1; j++){
                    full[j] = full[j+1];
                }
            }
        }
        /*for (int i : full){
            System.out.println(i);
        }*/
       //initiate a new array to store the modified array
        //remove the last three elements
        int removed[] = new int[full.length-deleted.size()];
        for (int i = 0; i < removed.length; i++){
            removed[i] = full[i];
    }
        //call the method
        printMissing(removed);
        /*for (int i : removed){
            System.out.println(i);
        }*/


}
}
