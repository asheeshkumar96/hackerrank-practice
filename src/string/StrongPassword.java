package string;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class StrongPassword {

	// Complete the minimumNumber function below.
	static int minimumNumber(int n, String password) {
		// Return the minimum number of characters to make the password strong
		boolean containsDigit = false;
		boolean containsUppercase = false;
		boolean containsLowercase = false;
		boolean containsSpecials = false;
		
		for (int i = 0; i < password.length(); i++) {
			if (!containsUppercase && password.charAt(i) >= 'A' && password.charAt(i) <= 'Z' + 1) {
				containsUppercase = true;
			} else if (!containsLowercase && password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
				containsLowercase = true;
			} else if (!containsDigit && password.charAt(i) >= '0' && password.charAt(i) <= '9') {
				containsDigit = true;
			} else if (!containsSpecials && ((password.charAt(i) >= 32 && password.charAt(i) <= 47)
					|| (password.charAt(i) >= 58 && password.charAt(i) <= 64)
					|| (password.charAt(i) >= 91 && password.charAt(i) <= 96)
					|| (password.charAt(i) >= 123 && password.charAt(i) <= 126))) {
				containsSpecials = true;
			}
		}
		//System.out.println("containsDigit = " + containsDigit + " , containsLowercase = "  + containsLowercase + ", containsUppercase = " + containsUppercase + " , containsSpecials = " + containsSpecials);
		int requiredDigits = 0;
		if(!containsDigit) {
			requiredDigits++;
		}
		if(!containsLowercase) {
			requiredDigits++;
		}
		if(!containsUppercase) {
			requiredDigits++;
		}
		if(!containsSpecials) {
			requiredDigits++;
		}
		
		// if the required digits is less than or equal to the number of chars needed to make string 6 digit
		if(requiredDigits <= 6 - password.length()) {
			return 6 - password.length();
		} else {
			 return requiredDigits;
		}
	} // there might be another solution using regex's util.regex's .matches(regex) method

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String password = scanner.nextLine();

		int answer = minimumNumber(n, password);

		bufferedWriter.write(String.valueOf(answer));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
