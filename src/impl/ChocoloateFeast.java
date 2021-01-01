package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ChocoloateFeast {

	
	// Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
    	int numbersOfChockos = (n/c);
    	int remainingWrappers = numbersOfChockos;
    	while(remainingWrappers >= m) {
    		int purchasedChokos = remainingWrappers / m;
    		int remainedWrap = remainingWrappers % m;
    		numbersOfChockos += purchasedChokos;
    		remainingWrappers = purchasedChokos + remainedWrap;
    	}
    	return numbersOfChockos;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
