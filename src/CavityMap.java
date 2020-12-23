import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CavityMap {

	// Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
    	// if grid length is less than two then return because they all are on border
    	if(grid.length <= 2) {
    		return grid;
    	}
    	
    	StringBuilder[] sbGrid = new StringBuilder[grid.length];
    	for(int i = 0; i < sbGrid.length; i++) {
    		sbGrid[i] = new StringBuilder(grid[i]);
    	}
    	
    	for(int i = 1; i < sbGrid.length - 1; i++) {
    		for(int j = 1; j < sbGrid.length - 1; j++) { // since square matrix
    			// Check for cavity
    			char currentCharacter = sbGrid[i].charAt(j);
    			if(currentCharacter != 'X') {
    				int currentIntChar = sbGrid[i].charAt(j); // - 48; // The ASCII value of zero is 48
    				//System.out.println("Current character in integer is:" + currentIntChar);
        			if( sbGrid[i].charAt(j - 1) < currentIntChar &&
        					sbGrid[i].charAt(j + 1) < currentIntChar &&
        					sbGrid[i - 1].charAt(j) < currentIntChar &&
        					sbGrid[i + 1].charAt(j) < currentIntChar ) {
        				// setting the char to X. 
        				sbGrid[i].setCharAt(j, 'X');
        			}
    			}
    		}
    	}
    	
    	for(int i = 0; i < sbGrid.length; i++) {
    		grid[i] = sbGrid[i].toString();
    	}
    	return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
