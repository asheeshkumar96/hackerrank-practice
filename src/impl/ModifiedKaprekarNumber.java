package impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModifiedKaprekarNumber {

	// Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
    	List<Integer> kaprekarNumberList = new ArrayList<Integer>();
    	for(int i = p; i <= q; i++) {
    		if(isKaprekarNumber(i)) {
    			kaprekarNumberList.add(i);
    		}
    	}
 
    	if(kaprekarNumberList.isEmpty()) {
    		System.out.println("INVALID RANGE");
    	} else {
    		for(Integer value: kaprekarNumberList) {
    			System.out.print(value + " ");
    		}
    		System.out.println();
    	}
    }
    
    static boolean isKaprekarNumber(long num) {
    	long squared = num * num;
    	int lengthOfNum = lengthOfNum(num);
    	long divider = (long) Math.pow(10, lengthOfNum);
    	long r =  squared % divider;
    	long l = squared / divider;
    	return (r + l) == num;
    }
    
    static int lengthOfNum(long num) {
    	int counter = 0; 
    	while(num != 0) {
    		num = num / 10;
    		counter++;
    	}
    	return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
