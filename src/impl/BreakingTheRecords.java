package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BreakingTheRecords {

	// Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
    	int minScore, maxScore;
    	minScore = maxScore = scores[0];
    	int leastBreakCount = 0;
    	int maxBreakCount = 0;
    	for(int i = 1; i < scores.length; i++) {
    		if(scores[i] < minScore) {
    			leastBreakCount++;
    			minScore = scores[i];
    		}
    		if(scores[i] > maxScore) {
    			maxBreakCount++;
    			maxScore = scores[i];
    		}
    	}
    	return new int[] {maxBreakCount, leastBreakCount};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
