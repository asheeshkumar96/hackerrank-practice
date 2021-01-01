package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BeautifulTriplets {

	// Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
    	int beautifulTriplets = 0;
    	for(int i = 0; i < arr.length - 2; i++) {
    		for(int j = i + 1; j < arr.length - 1; j++) {
    			if(arr[j] - arr[i] == d) {
    				for(int k = j + 1; k < arr.length; k++) {
        				if(arr[k] - arr[j] == d) {
        					beautifulTriplets++;
        				}
        			}
    			}
    		}
    	}
    	return beautifulTriplets;
    }
    
    // from discussion, but fails test case
    static int beautifulTripletsLinear(int d, int[] arr) {
    	int beautifulTriplets = 0;
    	HashSet<Integer> set = new HashSet<>();
    	for(int i = 0; i < arr.length; i++ ) {
    		if(set.contains(arr[i] - d) && set.contains(arr[i] - 2 * d) ) {
    			beautifulTriplets++;
    		}
    		set.add(arr[i]);
    	}
    	return beautifulTriplets;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
	
}
