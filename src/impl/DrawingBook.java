package impl;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class DrawingBook {

	/*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        int pagesFromFront = p / 2;
        int pagesFromBack = n / 2 - p / 2;
        //System.out.printf("fromFront=%s, fromBack=%s\n", pagesFromFront, pagesFromBack);
        return Math.min(pagesFromFront, pagesFromBack);
    }
    
    static int pageCountAlternate(int n, int p) {
        int totalPageTurnCountFromFront = n / 2;
        int targetPageTurnCountFromFront = p / 2;
        int targetPageTurnCountFromBack = totalPageTurnCountFromFront - targetPageTurnCountFromFront;
        return Math.min(targetPageTurnCountFromFront, targetPageTurnCountFromBack);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
