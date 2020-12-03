import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SalesByMatch {

	// Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for(int value : ar) {
			freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
		}
		
		int pairsOfSocks = 0;
		for(int value : freqMap.values()) {
			pairsOfSocks += (value / 2);
		}
		return pairsOfSocks;
    }
    
    static int sockMerchantWithSet(int n, int[] ar) {
    	Set<Integer> colors = new HashSet<Integer>();
		int pairsOfSocks = 0;
		for(int value : ar) {
			if(colors.contains(value)) {
				colors.remove(value);
				pairsOfSocks++;
			} else {
				colors.add(value);
			}
		}
		return pairsOfSocks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
