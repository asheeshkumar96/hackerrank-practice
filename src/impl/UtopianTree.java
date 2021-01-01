package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class UtopianTree {

	// Complete the utopianTree function below.
    static int utopianTree(int n) {
    	int initialHeight = 1;
    	for(int i = 1; i <= n; i++) {
    		if((i & 1) == 1) {
    			//System.out.println("Odd");
    			initialHeight *= 2;
    		} else {
    			//System.out.println("Even");
    			initialHeight++;
    		}
    	}
    	return initialHeight;
    }
    
    // copied from discussions 
    static int utopianTreeAlternative(int n) {
    	return ~(~1<<(n>>1)) << n%2;
    }
    static int utopianTreeAnotherAlt(int n) {
    	return ~(~1<<(n>>1)) << n%2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
