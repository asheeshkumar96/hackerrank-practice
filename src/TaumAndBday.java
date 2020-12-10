import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.LongStream;

public class TaumAndBday {

	public static long taumBday(long b, long w, long bc, long wc, long z) {
		return b * Math.min(bc, wc + z) + w * Math.min(wc, bc + z);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
 
		long t = Long.parseLong(bufferedReader.readLine().trim());

		LongStream.range(0, t).forEach(tItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				long b = Long.parseLong(firstMultipleInput[0]);

				long w = Long.parseLong(firstMultipleInput[1]);

				String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				long bc = Long.parseLong(secondMultipleInput[0]);

				long wc = Long.parseLong(secondMultipleInput[1]);

				long z = Long.parseLong(secondMultipleInput[2]);

				long result = taumBday(b, w, bc, wc, z);

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
