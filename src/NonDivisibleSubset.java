import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NonDivisibleSubset {

	/*
	 * Complete the 'nonDivisibleSubset' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER k 2. INTEGER_ARRAY s
	 */

	public static int nonDivisibleSubset(int k, List<Integer> s) {
		// Write your code here
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>(); // a better approach is to use arrays of length k
		for(int value : s) {
			int remainder = value % k;
			freqMap.put(remainder, freqMap.getOrDefault(remainder, 0) + 1);
		}
		int count = (freqMap.getOrDefault(0, 0) > 0 ) ? 1 : 0;
		for(int i = 1; i <= k / 2; i++) {
			if(i !=  (k - i) ) {
				count += Math.max(freqMap.getOrDefault(i, 0), freqMap.getOrDefault(k - i, 0) );
			} else {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = nonDivisibleSubset(k, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
