package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EqualizeTheArray {

	// Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
    	Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    	int maxFrequency = Integer.MIN_VALUE;
    	for(int key : arr) {
    		Integer oldFrequency = freqMap.getOrDefault(key, 0);
    		freqMap.put(key, oldFrequency + 1);
    		if(maxFrequency < oldFrequency + 1) {
    			maxFrequency = oldFrequency + 1;
    		}
    	}
    	/*
    	int minDeletions = Integer.MAX_VALUE;
    	Set<Integer> keySet = freqMap.keySet();
    	for(int key : keySet) {
    		Integer frequency = freqMap.getOrDefault(key, 0);
    		if(arr.length - frequency < minDeletions) {
    			minDeletions = (arr.length - frequency);
    		}
    	}
    	return minDeletions;
    	*/
    	return arr.length - maxFrequency;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
