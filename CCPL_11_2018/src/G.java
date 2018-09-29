import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class G {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(in.readLine());
		if (n > 2) {
			point[] arr = new point[n];
			for (int i = 0; i < n; i++) {

				String[] pAct = in.readLine().split(" ");
				int x = Integer.parseInt(pAct[0]);
				int y = Integer.parseInt(pAct[1]);
				point p = new point(x, y);
				arr[i] = p;
			}

			int cantidad = 0;

			for (int i = 0; i < n; i++) {
				point p1 = arr[i];
				for (int j = i + 1; j < n; j++) {
					point p2 = arr[j];
					int d1 = dist(p1, p2);
					for (int k = j + 1; k < n; k++) {
						point p3 = arr[k];
						int d2 = dist(p2, p3);
						int d3 = dist(p1, p3);
						if (d1 == d2 + d3) {
							cantidad++;
						} else if (d2 == d1 + d3) {
							cantidad++;
						} else if (d3 == d1 + d2) {
							cantidad++;
						}
					}
				}
			}

			out.write(cantidad + "\n");

		} else {
			out.write("0\n");
		}

		out.close();
	}

	static int dist(point p1, point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}

	static class point {

		int x;
		int y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
