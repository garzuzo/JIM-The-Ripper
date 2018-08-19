import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.TreeSet;

public class A {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(in.readLine());

		while (n != 0) {

			TreeMap<Integer, Integer> bols = new TreeMap<>();
			TreeSet<trip> trips = new TreeSet<>();

			for (int i = 0; i < n; i++) {
				String[] dat = in.readLine().split(" ");
				int cant = Integer.parseInt(dat[1]);
				if (cant > 0) {					
					bols.put(i, cant);
				}
				trips.add(new trip(Integer.parseInt(dat[0]), i));

			}

			int dis = 0;

			for (trip i : trips) {
				if (!bols.isEmpty()) {
					Integer k = bols.floorKey(i.p - 1);
					if (k != null) {
						dis += i.l / 2;
						if (bols.get(k) == 1) {
							bols.remove(k);
						} else {
							bols.replace(k, bols.get(k) - 1);
						}
					}else {
						dis += i.l;
					}
				} else {
					dis += i.l;
				}
			}

			out.write(dis + "\n");

			n = Integer.parseInt(in.readLine());
		}

		out.close();

	}

	static class trip implements Comparable<trip> {
		int l;
		int p;
		boolean op;

		public trip(int l, int p) {
			this.l = l;
			this.p = p;
		}

		@Override
		public int compareTo(trip o) {
			return this.l != o.l ? o.l - this.l : this.p - o.p;
		}

		@Override
		public String toString() {

			return p + " " + l;
		}
	}

}
