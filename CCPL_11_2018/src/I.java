import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class I {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(in.readLine());
		
		String lin = in.readLine();
		
		int P = 0;
		int N = 0;
		int I = 0;
		
		for (int i = 0; i < n; i++) {
			if (lin.charAt(i) == 'N') {
				N++;
			}else if (lin.charAt(i) == 'P') {
				P++;
			}else {
				I++;
			}
		}
		
		if (P > n/2) {
			out.write("SI\n");
		}else if (P+I > n/2) {
			out.write("INDECISOS\n");
		}else {
			out.write("NO\n");
		}
		
		out.close();

	}

}
