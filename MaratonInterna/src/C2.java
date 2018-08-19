import java.io.*;
import java.util.*;

public class C2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String dat[] = in.readLine().split(" ");

		int n = Integer.parseInt(dat[0]);
		int b = Integer.parseInt(dat[1]);

		while (n != 0 && b != 0) {

			int[][] matrix = new int[n][n];

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (i != j)
						matrix[i][j] = 100000000;
				}
			}
			for (int c = 0; c < b; c++) {
				dat = in.readLine().split(" ");
				int i = Integer.parseInt(dat[0]) - 1;
				int j = Integer.parseInt(dat[1]) - 1;
				int w = Integer.parseInt(dat[2]);

				matrix[i][j] = w;
				matrix[j][i] = -w;

			}

			boolean ret = bellman(matrix);
			System.out.println(ret ? "Y" : "N");
			dat = in.readLine().split(" ");

			n = Integer.parseInt(dat[0]);
			b = Integer.parseInt(dat[1]);

		}
	}

	static boolean bellman(int[][] matrix) {
		boolean hasNegativeCicle = false;

		int[] dist = new int[matrix.length];

		Arrays.fill(dist, 100000000);
		dist[0] = 0;

		for (int i = 0; i < matrix.length - 1; i++) {

			for (int u = 0; u < matrix.length; u++) {

				for (int j = 0; j < matrix.length; j++) {

					dist[j] = Math.min(dist[j], dist[u] + matrix[u][j]);
				}
			}
		}
		for (int u = 0; u < matrix.length; u++) {

			for (int j = 0; j < matrix.length; j++) {

				// int v = matrix[u][j];

				if (dist[j] > dist[u] + matrix[u][j])
					hasNegativeCicle = true;
			}
		}
		return hasNegativeCicle;
	}
}
