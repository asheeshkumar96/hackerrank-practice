package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SequenceEquation {
	// Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
    	// naive solution
    	int[] permutations =  new int[p.length];
    	for(int i = 0; i < p.length; i++) {
    		int tempIndex = getIndex(p, i+1);
    		int index = getIndex(p, tempIndex + 1);
    		System.out.println("n = " + (i + 1) + " tempIndex="+tempIndex + " index =" + index);
    		permutations[i] = index + 1;
    	}
    	return permutations;
    }
    
    static int getIndex(int[] p, int value) {
    	int index = -1;
    	for(int i = 0; i < p.length; i++) {
    		if(p[i] == value) {
    			index = i;
    			break;
    		}
    	}
    	return index;
    }
    
    // copied from discussion
    static void permutationEquationAlter(int[] p) {
    	int[] p_inverse = new int[p.length + 1];
    	for (int x = 1; x <= p.length; x++) {
            p_inverse[p[x - 1]] = x;
        }
    	
    	for(int x = 1; x <= p.length; x++) {
    		int y = p_inverse[p_inverse[x]];
    		System.out.println(y);
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        //int[] result = permutationEquation(p);
        permutationEquationAlter(p);
        
        /*
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();
		*/
        bufferedWriter.close();

        scanner.close();
    }
}
