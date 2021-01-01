package impl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BetweenTwoSets {
	
	
	public static int getTotalX(List<Integer> a, List<Integer> b) {
		int lcmOfArrayA = lcm(a);
		int gcdOfArrayB = gcd(b);
		int count = 0;
		int temp = lcmOfArrayA;
		while(temp <= gcdOfArrayB) {
			if(gcdOfArrayB % temp == 0) {
				count++;
			}
			temp += lcmOfArrayA;
		}
		return count;
	}
	
	private static int lcm(List<Integer> input) {
		int result = input.get(0);
		for(int i = 1; i < input.size(); i++) { 
			result = lcm(result, input.get(i));
		}
		return result;
	}
	
	private static int lcm(int a, int b) {
		return a * ( b / gcd(a, b));
	}
	
	private static int gcd(List<Integer> input) {
		int result = input.get(0);
		for(int i = 1; i < input.size(); i++) {
			result = gcd(result, input.get(i));
		}
		return result;
	}
	
	private static int gcd(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = BetweenTwoSets.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
