package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class StrangeCounter {

	static long strangeCounter(long t) {
    	long initialNumber = 3;
    	while (t > initialNumber) {
    		t -= initialNumber;
    		initialNumber *= 2;
    	}
    	return initialNumber - t + 1;
    }
    
    static long strangeCounterNaive(long t) {
    	// naive method, exceeds time limit
    	long initialValue = 3;
    	long currentValue = 3;
    	long timeCounter = 1;
    	while(currentValue > 0 &&  timeCounter < t) {
    		t--;
    		currentValue--;
    		if(currentValue == 0) {
    			initialValue = 2 * initialValue;
    			currentValue = initialValue;
    		}
    	}
    	return currentValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
