import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class JumpingOnTheCloudss {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int minimumJumps = 0;
		int i = 0;
		while (i < c.length - 1) {
			//System.out.println("i+1=" + (i + 1) + "  i+2=" + (i + 2));
			if (i + 1 == c.length - 1) {
				//System.out.println("plus one equls last Index");
				minimumJumps++;
				i++;
			} else if (i + 2 == c.length - 1) {
				//System.out.println("plus two equals last Index");
				minimumJumps++;
				i = i + 2;
			} else if (c[i + 1] == 0 && c[i + 2] == 1) {
				minimumJumps++;
				i++;
			} else {
				minimumJumps++;
				i = i + 2;
			}
		}
		return minimumJumps;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
