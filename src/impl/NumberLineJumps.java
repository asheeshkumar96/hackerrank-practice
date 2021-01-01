package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class NumberLineJumps {

	// Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
    	int distDiff = Math.abs(x2 - x1); // the distance
    	if(x2 > x1 && v2 >= v1) { // here equal to is edge case
    		return "NO";
    	}
    	
    	// if A is fast but behind
    	int speedDiff;
    	if(v1 > v2) {
    		speedDiff = v1 - v2;
    	} else {
    		// B is fast
    		speedDiff = v2 - v1;
    	}
    	
    	int multiple = (int) (distDiff / speedDiff);
    	if(speedDiff * multiple == distDiff) {
    		return "YES";
    	}
    	return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
