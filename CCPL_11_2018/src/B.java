import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] dat = in.readLine().split(" ");

		long D = Long.parseLong(dat[0]);
		long M = Long.parseLong(dat[1]);
		long D1 = Long.parseLong(dat[2]);
		long N = Long.parseLong(dat[3]);
		long D2 = Long.parseLong(dat[4]);

		int molestados = 0;

		while (D1 > D && D > 0 && (M > 0 || N > 0)) {

			if (M > 0) {
				D = D - (D1 - D);
				M--;
				molestados++;
			} else if (N > 0 && D2 > D) {
				D = D - (D2 - D);
				N--;
				molestados++;
			} else if (D2 <= D){
				break;
			}

		}

		if (D > 0) {
			out.write("-1\n");
		} else {
			out.write(molestados + "\n");
		}

		out.close();
	}

}
