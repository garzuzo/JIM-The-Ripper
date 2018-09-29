import java.io.*;
import java.util.*;

public class A {

	static StringBuilder ret;
	static caja cajita;

	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] data = in.readLine().split(" ");

		n = Integer.parseInt(data[0]);
		m = Integer.parseInt(data[1]);

		char[][] arr = new char[n][m];

		boolean parada = true;

		int filaCaja = 0;
		int colCaja = 0;
		for (int i = 0; i < n; i++) {
			char[] fila = in.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				arr[i][j] = fila[j];
				if (arr[i][j] == 'C') {
					filaCaja = i;
					colCaja = j;
				}

			}
			cajita = new caja();
			cajita.parada = true;
			dfs(arr, filaCaja, colCaja, new StringBuilder());

		}

	}

	static void dfs(char[][] arr, int i, int j, StringBuilder answ) {

		if (arr[i][j] == 'E') {
			if (ret == null) {
				ret = answ;
			} else if (ret.length() > answ.length())
				ret = answ;
		} else {

			if (cajita.parada) {

				cajita.parada = false;

				if (j - 1 < m) {
					answ.append("L");
					dfs(arr, i, j--, answ);
					cajita.cambioColumna = true;

				} else if (j + 1 < m) {
					answ.append("R");
					cajita.cambioColumna = true;
					dfs(arr, i, j--, answ);
				} else if (i - 1 >= 0) {
					answ.append("D");
					cajita.cambioColumna = false;
					dfs(arr, i, j--, answ);
				} else if (i + 1 < n) {
					answ.append("U");
					cajita.cambioColumna = false;
					dfs(arr, i, j--, answ);
				}
			} else {

				cajita.parada = true;

				if (cajita.cambioColumna) {

					if (i + 1 < n) {
						answ.append("U");

						dfs(arr, i++, j, answ);
					} else if (i - 1 >= 0) {
						answ.append("D");
						dfs(arr, i--, j, answ);

					}

				} else {

					if (j + 1 < m) {
						answ.append("R");
						dfs(arr, i, j++, answ);
					} else if (j-- >= 0) {
						answ.append("L");
						dfs(arr, i, j--, answ);

					}

				}
			}

		}

	}

	static class caja {

		boolean parada;

		boolean cambioColumna;

	}

}
