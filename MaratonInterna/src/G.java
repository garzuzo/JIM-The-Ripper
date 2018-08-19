import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;

public class G {

	static HashSet<Integer> friends;
	static HashMap<Integer, node> nodos;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String lin = in.readLine();

		while (lin != null && !lin.isEmpty()) {

			String[] dat = lin.split(" ");

			int n = Integer.parseInt(dat[0]);
			int f = Integer.parseInt(dat[1]);

			nodos = new HashMap<>();

			for (int i = 1; i <= n; i++) {
				nodos.put(i, new node(i));
			}

			for (int i = 1; i < n; i++) {
				dat = in.readLine().split(" ");
				int o = Integer.parseInt(dat[0]);
				int fi = Integer.parseInt(dat[1]);
				int w = Integer.parseInt(dat[2]);

				nodos.get(o).sons.put(fi, w);
			}

			friends = new HashSet<>();

			dat = in.readLine().split(" ");

			for (int i = 0; i < f; i++) {
				friends.add(Integer.parseInt(dat[i]));
			}

			lin = in.readLine();
		}

		out.close();

	}

	static class node {
		int id;

		HashMap<Integer, Integer> sons;

		public node(int id) {
			this.id = id;
			sons = new HashMap<>();
		}

	}

}
