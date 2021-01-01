package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {

	// Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
    	List<Integer> sticks = new ArrayList<Integer>();
    	Arrays.sort(arr);
    	sticks.add(arr.length);
    	for(int i = 1; i< arr.length; i++) {
    		if(arr[i] != arr[i - 1]) {
    			//System.out.println("i="+i+"count="+(arr.length - i));
    			sticks.add(arr.length - i);
    		}
    	}
    	int[] returnSticks = sticks.stream().mapToInt(i -> i).toArray();
    	return returnSticks;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out) );

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
