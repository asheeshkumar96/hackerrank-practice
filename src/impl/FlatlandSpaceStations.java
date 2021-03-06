package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStations {

	// Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {    	
    	Arrays.sort(c);
    	int maxDistance =  c[0];

    	for(int i = 0; i < c.length - 1; i++) {
    		maxDistance = Math.max(maxDistance, (c[i + 1] - c[i]) / 2 );
    	}
    	// reconsidering the distance from the last space station
    	maxDistance = Math.max(maxDistance, n - 1 - c[c.length - 1]);
    	return maxDistance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
