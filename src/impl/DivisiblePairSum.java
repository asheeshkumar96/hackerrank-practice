package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class DivisiblePairSum {
	
	// Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
    	int count = 0;
    	for(int j = 1; j < ar.length; j++) {
    		for(int i = 0; i < j; i++) {
    			if( (ar[i] + ar[j]) % k == 0) {
    				count++;
    			}
    		}
    	}
    	return count;
    }
    
    static int divisibleSumPairsBucket(int n, int k, int[] ar) {
    	int[] bucket = new int[k];
    	int count = 0;
    	for(int value : ar) {
    		int modValue = value % k;
    		count += bucket[(k - modValue) % k]; // adds # of elements in complement bucket
    		bucket[modValue]++; // saves in bucket
    	}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
