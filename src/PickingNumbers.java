import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;


public class PickingNumbers {
	/*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    static int pickingNumbers(List<Integer> a) {
    	// Write your code here
    	int[] frequency = new int[101];
    	int maxLength = Integer.MIN_VALUE; 
    	//HINT : ********   What is counting sort ???????
    	for(int i = 0; i < a.size(); i++) {
    		int index  = a.get(i);
    		frequency[index]++;
    	}
    	
    	for(int i = 1; i < frequency.length; i++) {
    		maxLength = Math.max(maxLength, frequency[i] + frequency[i - 1]);
    	}
    	return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = PickingNumbers.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
