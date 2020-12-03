import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FormingMagicSquare {
	
	// Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
    	int[][][] magicMatrices = new int[][][] {
    		new int[][] {
    			{8, 1, 6},
    			{3, 5, 7},
    			{4, 9, 2}
    		},
    		new int[][] {
    			{6, 1, 8},
    			{7, 5, 3},
        		{2, 9, 4}
    		}, 
    		new int[][] {
    			{4, 9, 2},
    			{3, 5, 7},
    			{8, 1, 6}
    		},
    		new int[][] {
    			{2, 9, 4},
    			{7, 5, 3},
    			{6, 1, 8}
    		}, 
    		new int[][] {
    			{8, 3, 4},
    			{1, 5, 9},
    			{6, 7, 2}
    		},
    		new int[][] {
    			{4, 3, 8},
    			{9, 5, 1},
    			{2, 7, 6}
    		},
    		new int[][] {
    			{6, 7, 2},
    			{1, 5, 9},
    			{8, 3, 4}
    		},
    		new int[][] {
    			{2, 7, 6},
    			{9, 5, 1},
    			{4, 3, 8}
    		}
    	};
    	int minimalCost = Integer.MAX_VALUE;
    	for(int[][] magicMatrix: magicMatrices) {
    		int cost = 0;
    		for(int i = 0; i < s.length; i++) {
    			for(int j = 0; j < s[i].length; j++) {
    				int diff = magicMatrix[i][j] - s[i][j];
    				cost += Math.abs(diff);
    			}
    		}
    		if(cost < minimalCost) {
    			minimalCost = cost;
    		}
    	}
    	return minimalCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out) );

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
