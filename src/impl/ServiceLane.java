package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ServiceLane {

	// Complete the serviceLane function below.
    static int[] serviceLane(int n, int[][] cases, int[] width) {
    	int[] minPossibleWidth = new int[cases.length];
    	for(int i = 0; i < cases.length; i++) {
    		int min = Integer.MAX_VALUE;
    		int j = cases[i][0];
    		int k = cases[i][1];
    		System.out.println("j = " + j + " k = " + k);
    		for(; j <= k; j++) {
    			min = Math.min(min, width[j]);
        		System.out.println("i = " + j + "j =" + j);
    		}
    		minPossibleWidth[i] = min;
    	}
    	return minPossibleWidth;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nt = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(n, cases, width);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}