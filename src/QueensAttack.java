import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class QueensAttack {

	// Complete the queensAttack function below.
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
		// Optimized solution
		
		// closest distanc in all directions
		int upwardDistance = 0, downwardDistance = 0, leftDistance = 0, rightDistance = 0;
		int northEastDist = 0, northWestDist = 0, southWestDist = 0, southEastDist = 0;
		
		
		return 0;
	}
	
	private static int calculateDistanceBetweenTwoPoints(int x1, int y1, int x2, int y2) {
		return 0;
	}
	
	// fails some test cases
    static int queensAttackBrute(int n, int k, int r_q, int c_q, int[][] obstacles) {
    	int[][] chessboard = new int[n][n];
    	for(int i = 0; i < obstacles.length; i++) {
    		chessboard[obstacles[i][0] - 1][obstacles[i][1] - 1] = 1;
    	}
    	int attackNums = 0;
    	// UPWARD direction
    	for(int i = r_q; i < n; i++) {
    		//System.out.println("i=" + i + "j=" + (c_q - 1));
    		if(chessboard[i][c_q - 1] == 1) {
    			break;
    		}
    		attackNums++;
    	}
    	// DOWNWARD direction
    	for(int i = r_q - 2; i >= 0; i--) {
    		if(chessboard[i][c_q - 1] == 1) {
    			break;
    		}
    		attackNums++;
    	}
    	// LEFT direction
    	for(int i = c_q - 2; i >= 0; i--) {
    		if(chessboard[r_q - 1][i] == 1) {
    			break;
    		}
    		attackNums++;
    	}
    	// RIGHT direction
    	for(int i = c_q; i < n; i++) {
    		if(chessboard[r_q - 1][i] == 1) {
    			break;
    		}
    		attackNums++;
    	}
    	// NORTH-EAST direction
    	for(int i = r_q, j = c_q; i < n && j < n; i++, j++) {
    		if(chessboard[i][j] == 1) {
    			break;
    		}
    		attackNums++;
    	}
    	// SOUTH-WEST direction
    	for(int i = r_q - 2, j = c_q - 2; i >= 0  && j >= 0; i--, j--) {
    		if(chessboard[i][j] == 1) {
    			break;
    		}
    		attackNums++;
    	}
    	// NORTH-WEST direction
    	for(int i = r_q, j = c_q - 2; i < n && j >= 0; i++, j--) {
    		if(chessboard[i][j] == 1) {
    			break;
    		}
    		attackNums++;
    	}
    	// SOUTH-EAST direction
    	for(int i = r_q - 2, j = c_q; i >= 0 && j < n; i--, j++) {
    		if(chessboard[i][j] == 1) {
    			break;
    		}
    		attackNums++;
    	}
    	System.out.println("possible attacks in all the 8 directions=" + attackNums);
    	return attackNums;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
