import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RepeatedString {

	// Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	int countOfCharA = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == 'a') {
    			countOfCharA++;
    		}
    	}
    	long overAllCount = countOfCharA * (n / s.length());
    	for(int i = 0; i < n % s.length(); i++) {
    		if(s.charAt(i) == 'a') {
    			overAllCount++;
    		}
    	}
    	return overAllCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
