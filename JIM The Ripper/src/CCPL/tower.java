package CCPL;

import java.io.*;
import java.util.*;

public class tower {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));

		int cont = 1;
		while (true) {
			int n = Integer.parseInt(lect.readLine());

			if (n == 0)
				break;

			int[][] matrix = new int[n][3];
			for (int i = 0; i < n; i++) {
				String[] act = lect.readLine().split(" ");

				matrix[i][0] = Integer.parseInt(act[0]);
				matrix[i][1] = Integer.parseInt(act[1]);
				matrix[i][2] = Integer.parseInt(act[2]);

			}

			esc.write("Case " + cont + ": maximum height = " + cont + "\n");
			cont++;
		}

	}

	static class block implements Comparator<block>{

		int x;
		int y;
		int z;

		block(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compare(block o1, block o2) {
			// TODO Auto-generated method stub
			return o1.x>o2.x&&o1.y>o2.y?1:0;
		}

	}
}
