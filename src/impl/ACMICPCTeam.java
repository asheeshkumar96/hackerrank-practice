package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ACMICPCTeam {

	// Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
    	int count;
    	int max = Integer.MIN_VALUE;
    	int maxCountFreq = 0;
    	for(int i = 0; i < topic.length - 1; i++) {
    		for(int j = i + 1; j < topic.length; j++) {
    			count = 0;
    			for(int m = 0; m < topic[i].length(); m++) {
    				if(topic[i].charAt(m) == '1' || topic[j].charAt(m) == '1') {
    					count++;
    				}
    			}
    			if(count > max) {
    				max = count;
    				maxCountFreq = 1;
    			} else if(count == max){
    				maxCountFreq++;
    			}
    		}
    	}
    	return new int[] {max, maxCountFreq};
    }
    
    static int[] acmTeamBitwiseTestCasesFail(String[] topic) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < topic.length - 1; i++) {
    		for(int j = i + 1; j < topic.length; j++) {
    			int attendeeDataOne = Integer.parseUnsignedInt(topic[i], 2);
    			int attendeeDataTwo = Integer.parseUnsignedInt(topic[j], 2);
    			int topicsCovered = (attendeeDataOne | attendeeDataTwo);
    			//System.out.println("attendeeDataOne=" + topic[i] + " , attendeeDataTwo = " + attendeeDataTwo + " , topicsCovered = " + Integer.toBinaryString(topicsCovered));
    			int teamTopics = numberOfDigitSets(topicsCovered);
    			map.put(teamTopics, map.getOrDefault(teamTopics, 0) + 1);
    		}
    	}
    	int maxTopics = Collections.max(map.keySet());
    	 
    	return new int[] {maxTopics, map.get(maxTopics)};
    }
    
    static int numberOfDigitSets(int num) {
    	int count = 0; 
        while (num > 0) { 
            count += num & 1; 
            num >>= 1; 
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
