package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SuperReducedString {

	// Complete the superReducedString function below.
    static String superReducedString(String s) {
    	StringBuilder sb  = new StringBuilder(s);
    	int length = s.length();
    	int i = 0; 
    	while(i < length - 1) {
    		if(sb.charAt(i) == sb.charAt(i + 1)) {
    			// remove both characters
    			sb.replace(i, i + 2, "");
    			length -= 2;
    			i = 0;
    		} else {
    			i++;
    		}
    	}
    	return sb.toString().equals("") ? "Empty String" : sb.toString();
    } // another solution can be done with stack of characters

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
