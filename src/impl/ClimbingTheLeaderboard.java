package impl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class ClimbingTheLeaderboard {

	/*
	 * Complete the 'climbingLeaderboard' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY ranked 2. INTEGER_ARRAY player
	 */

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Write your code here
		Stack<Integer> stack  = new Stack<>();
		List<Integer> rankArray = new ArrayList<Integer>();
		for(int value : ranked) {
			if(stack.isEmpty() || stack.peek() != value) {
				stack.push(value);
			}
		}
		
		for(int i = 0; i < player.size(); i++) {
			while(!stack.isEmpty() && stack.peek() <= player.get(i)) {
				stack.pop();
			}
			stack.push(player.get(i));
			System.out.println("Rank:"+ ( stack.size()) );
			rankArray.add(stack.size());
		}
		return rankArray;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> result = climbingLeaderboard(ranked, player);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
