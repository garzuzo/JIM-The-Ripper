import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class F {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] dat = in.readLine().split(" ");

		int N = Integer.parseInt(dat[0]);
		int M = Integer.parseInt(dat[1]);

		dat = in.readLine().split(" ");

		HashMap<Integer, Integer> empresas = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int m = Integer.parseInt(dat[i]);
			if (!empresas.containsKey(m)) {
				empresas.put(m, 1);
			} else {
				empresas.replace(m, empresas.get(m) + 1);
			}
		}

		ArrayList<Integer> cantidades = new ArrayList<>();

		for (int i : empresas.keySet()) {
			cantidades.add(empresas.get(i));
		}

		Collections.sort(cantidades);

		if (empresas.size() == M) {
			out.write("0\n");
		} else if (empresas.size() == 1) {
			out.write("1\n");
		} else if (empresas.size() == 2 && cantidades.get(0) == 1) {
			if (M == 3) {
				out.write("1\n");
			} else
				out.write(M - 1 + "\n");
		} else {
			out.write(M + "\n");
		}

		out.close();
	}

}
