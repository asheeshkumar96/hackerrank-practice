package impl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DayOfTheProgrammer {

	// Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
    	StringBuilder dayOfTheProgrammer;
    	if(year > 1918) {
    		// Gregorian calendar to be applied
    		if( (year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0) {
    			dayOfTheProgrammer = new StringBuilder("12.09.").append(year);
    		} else {
    			dayOfTheProgrammer = new StringBuilder("13.09.").append(year);
    		}
    	} else if(year == 1918) {
    		// Special Case
    		dayOfTheProgrammer = new StringBuilder("26.09.1918");
    	} else {
    		// Julian calendar to be applied
    		if(year % 4 == 0) {
    			dayOfTheProgrammer = new StringBuilder("12.09.").append(year);
    		} else {
    			dayOfTheProgrammer = new StringBuilder("13.09.").append(year);
    		}
    	}
    	return dayOfTheProgrammer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
    
}
