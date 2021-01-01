package string;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CamelCase {

	// Complete the camelcase function below.
    static int camelcase(String s) {
    	if(s == null || s.length() == 0) {
    		return 0;
    	}
    	
    	int count = 1;
    	int lowerLimit = 'A' - 1;
    	int upperLimit = 'Z' + 1;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) > lowerLimit && s.charAt(i) < upperLimit) {
    			count++;
    		}
    	}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
