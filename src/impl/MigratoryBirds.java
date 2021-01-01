package impl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;


public class MigratoryBirds {
	
	// Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
    	int[] freqArray = new int[5 + 1];
    	for(int value : arr) {
    		freqArray[value] = freqArray[value] + 1;
    	}
    	
    	int index = 0;
    	for(int i = 0; i < freqArray.length; i++) {
    		if(freqArray[i] > freqArray[index]) {
    			index = i;
    		}
    	}
    	return index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
