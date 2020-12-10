import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class LisasWorkbook {

	// Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
    	int specialProblems = 0;
    	int pages = 1;
    	for(int i = 0; i < n; i++) {
    		//pages++;
    		int problem = arr[i];
    		for(int j = 1; j <= problem; j++) {
    			// is special problem ?
    			if(pages == j) {
    				specialProblems++;
    			}
    			// next page
    			if(j % k == 0) {
    				pages++;
    			}
    		}
    		if(problem % k != 0) {
        		pages++;
    		}
    	}
    	return specialProblems;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
