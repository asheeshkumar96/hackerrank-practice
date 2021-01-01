package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class LibraryFine {

	// Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    	int YEARLY_CHARGE = 10000;
    	int MONTHLY_CHARGE = 500;
    	int DAILY_CHARGE = 15;
    	int fees = 0;
    	if(y1 > y2) {
    		fees = YEARLY_CHARGE;
    	}
    	else if( y1 == y2) {
    		if(m1 > m2) {
    			fees = (m1 - m2) * MONTHLY_CHARGE;
    		} 
    		else if(m1 == m2) {
    			if(d1 > d2) {
    				fees = (d1 - d2) * DAILY_CHARGE;
    			}
    		}
    	}
    	return fees;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
