package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class HappyLadybugs {

	// from discussion
    static String happyLadybugs(String b) {
    	int[] ladybugs = new int['Z' - 'A' + 1];
    	boolean esp = false;
    	
    	// the number of ladybugs of each color is saved in ladybugs array
    	for(char c: b.toCharArray()) {
    		if(c != '_') {
    			ladybugs[c - 'A']++;
    		} else {
    			esp = true;
    		}
    	}
    	
    	// if there are no spaces, all the color satisfy the condition
    	if(!esp) {
    		for(int i = 1; i < b.length() - 1; i++) {
    			if(b.charAt(i) != b.charAt(i - 1)  && b.charAt(i) != b.charAt(i + 1)) {
    				return "NO";
    			}
    		}
    	}
    	// if there are spaces, there can not be a ladybug of a single color
    	for(int i: ladybugs) {
    		if(i == 1) return "NO";
    	}
    	
    	// if there is no unhappy ladybug
    	return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
