package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MinimumDistances {

	// Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
    	int minimumDistance = Integer.MAX_VALUE;
    	for(int i = 0; i < a.length - 1; i++) {
    		int j = i + 1;
    		while(j < a.length) {
    			if(a[i] == a[j]) {
    				int tempDist = j - i;
    	    		if(tempDist < minimumDistance) {
    	    			minimumDistance = tempDist;
    	    		}
    	    		break;
    			}
    			j++;
    		}
    	}
    	return minimumDistance == Integer.MAX_VALUE ? -1 : minimumDistance;
    } // this is bruteforce method, another solution can be done with Map storing lastIndices against values as key

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
