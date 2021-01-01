package impl;
import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

	// Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
    	if(n > 100) {
    		System.out.println("Constraints violated");
    		return;
    	}
    	BigInteger fact = BigInteger.ONE;
    	long limit = n;
    	while(limit > 0) {
    		fact = fact.multiply(BigInteger.valueOf(limit));
    		limit--;
    	}
    	System.out.println(fact);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
