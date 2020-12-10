import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class AppendAndDelete {

	// Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {    	
    	int firstStringLength = s.length();
    	int secondStringLength = t.length();
    	int maxPossibleMatchCharCount = firstStringLength < secondStringLength ? firstStringLength : secondStringLength;
    	int matchedChars = 0;
        // If Both string have anything common from start, count them
    	while(matchedChars < maxPossibleMatchCharCount &&  s.charAt(matchedChars) == t.charAt(matchedChars) ) {
    		matchedChars++;
    	}
    	/*
    	if(s.length() + t.length() - 2 * matchedChars  <= k) {
    		isPossible = true;
    	}
    	return isPossible ? "Yes": "No";
    	*/
    	// from discussion
    	// CASE A
    	if( (s.length() + t.length() - 2 * matchedChars) > k) {
    		return "No";
    	}
    	// CASE B
    	else if((s.length() + t.length() - 2 * matchedChars) % 2 == k % 2) {
    		return "Yes";
    	}
    	// CASE C
    	else if((s.length() + t.length() - k) < 0) {
    		return "Yes";
    	}
    	// CASE D
    	else {
    		return "No";
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
