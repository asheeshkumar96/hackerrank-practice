package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class HalloweenSale {

	
	// Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
    	int numberOfGames = 0;
    	while(s > 0) {
    		if(s - p >= 0) {
        		numberOfGames++;
        		s -= p;
    		} else {
    			break;
    		}
    		
    		if(p - d > m) {
    			p = p -d;
    		} else {
    			p = m;
    		}
    	}
    	return numberOfGames;
    }
    
    // There is an optimized solution based on Arithmetic Progression, some cases may fail
    static int howManyGameAP(int p, int d, int m, int s) {
    	int count;
    	if(s < 0) {
    		count = 0;
    	} else {
        	int nTerms = 1 + (p - m) / d;
        	count = nTerms;
        	int spentAmount = nTerms * (2 * p - (nTerms - 1) * d) / 2;
        	if(s >= spentAmount) {
        		count += (s - spentAmount) / m;
        	} else {
        		int b = 2 * p + d;
        		count = (int)   (b - Math.sqrt(b * b - 8 * d * s)) / (2 * d);
        		
        		// this is my method, not working hence commented
        		/*
        		int b = 2 * p - d;
        		count = (int) (-b + Math.sqrt(b * b + 8 * d * s) ) / (2 * d); // Shreedharaachaarya Method
        		*/
        	}
    	}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        //int answer = howManyGames(p, d, m, s);
        int answer = howManyGameAP(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
