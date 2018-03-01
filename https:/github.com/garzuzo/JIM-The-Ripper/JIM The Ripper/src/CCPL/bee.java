package CCPL;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class bee {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] dat = br.readLine().split(" ");
		int a = Integer.parseInt(dat[0]);
		int b = Integer.parseInt(dat[1]);

		HashMap<Integer, casilla> casillas = new HashMap<>();

		casilla uno = new casilla(1, 0);
		casillas.put(1, uno);
		for (int i = 2; i <= 7; i++) {
			casilla nueva = new casilla(i, 1);
			nueva.vecinas.add(uno);
			uno.vecinas.add(nueva);
			casilla previa = casillas.get(i - 1);
			previa.vecinas.add(nueva);
			nueva.vecinas.add(previa);
			casillas.put(i, nueva);
		}

		int colocadas = 7;
		int niveles = 1;

		while (a != 0 && b != 0) {

			int n1 = a;
			int n2 = b;

			int mayor = n1 > n2 ? n1 : n2;

			if (mayor > colocadas) {

				niveles++;

				for (int i = niveles; colocadas < mayor; i++) {

					int inicial = colocadas + 1 - 6 * (i - 1);

					int acolocar = colocadas + 1;

					casilla nueva = new casilla(acolocar, i);

					casilla previa = (casillas.get(acolocar - 1));

					nueva.vecinas.add(previa);
					previa.vecinas.add(nueva);

					casillas.put(acolocar, nueva);

					colocadas++;

					for (int j = 1; j < i - 1 && colocadas < mayor; j++) {

						acolocar = colocadas + 1;

						nueva = new casilla(acolocar, i);

						previa = casillas.get(acolocar - 1);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						previa = casillas.get(inicial);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						previa = casillas.get(inicial + 1);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						inicial++;
						colocadas++;

						casillas.put(acolocar, nueva);
					}

					if (colocadas < mayor) {

						acolocar = colocadas + 1;

						nueva = new casilla(acolocar, i);

						previa = casillas.get(acolocar - 1);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						previa = casillas.get(inicial);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						colocadas++;

						casillas.put(acolocar, nueva);
					}

					for (int j = 0; j < 4 && colocadas < mayor; j++) {

						for (int k = 1; k < i && colocadas < mayor; k++) {
							acolocar = colocadas + 1;

							nueva = new casilla(acolocar, i);

							previa = casillas.get(acolocar - 1);
							nueva.vecinas.add(previa);
							previa.vecinas.add(nueva);

							previa = casillas.get(inicial);
							nueva.vecinas.add(previa);
							previa.vecinas.add(nueva);

							previa = casillas.get(inicial + 1);
							nueva.vecinas.add(previa);
							previa.vecinas.add(nueva);

							inicial++;
							colocadas++;

							casillas.put(acolocar, nueva);
						}

						if (colocadas < mayor) {
							acolocar = colocadas + 1;

							nueva = new casilla(acolocar, i);
							previa = casillas.get(acolocar - 1);
							nueva.vecinas.add(previa);
							previa.vecinas.add(nueva);

							previa = casillas.get(inicial);
							nueva.vecinas.add(previa);
							previa.vecinas.add(nueva);
							colocadas++;

							casillas.put(acolocar, nueva);
						}

					}

					for (int k = 1; k < i && colocadas < mayor; k++) {
						acolocar = colocadas + 1;

						nueva = new casilla(acolocar, i);

						previa = casillas.get(acolocar - 1);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						previa = casillas.get(inicial);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						previa = casillas.get(inicial + 1);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						inicial++;
						colocadas++;

						casillas.put(acolocar, nueva);
					}

					if (colocadas < mayor) {

						acolocar = colocadas + 1;

						nueva = new casilla(acolocar, i);

						previa = casillas.get(acolocar - 1);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						previa = casillas.get(inicial);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						previa = casillas.get(inicial + 1);
						nueva.vecinas.add(previa);
						previa.vecinas.add(nueva);

						colocadas++;

						casillas.put(acolocar, nueva);
					}

				}

			}

			casilla v1 = casillas.get(n1);
			casilla v2 = casillas.get(n2);

			int n3 = 0;
			if (!v1.equals(v2)) {

				boolean[] vis = new boolean[mayor + 1];

				ArrayDeque<query> pendientes = new ArrayDeque<>();
				pendientes.add(new query(0, v1));

				boolean camino = false;

				while (!pendientes.isEmpty() && !camino) {
					query actual = pendientes.remove();
					vis[actual.cas.val] = true;
					for (casilla n : actual.cas.vecinas) {
						if (!vis[n.val]) {
							if (n.equals(v2)) {
								n3 = actual.l + 1;
								camino = true;
								break;
							} else {
								pendientes.add(new query(actual.l + 1, n));
							}
						}
					}
				}
			}

			bw.write("The distance between cells " + n1 + " and " + n2 + " is " + n3 + ".\n");
			dat = br.readLine().split(" ");
			a = Integer.parseInt(dat[0]);
			b = Integer.parseInt(dat[1]);
		}

		bw.close();

	}

	static class query {
		casilla cas;
		int l;

		public query(int l, casilla cas) {
			this.cas = cas;
			this.l = l;
		}

		@Override
		public String toString() {
			return l + " " + cas.toString();
		}

	}

	static class casilla {

		int lvl;
		int val;

		HashSet<casilla> vecinas;

		public casilla(int val, int lvl) {
			this.val = val;
			this.lvl = lvl;
			vecinas = new HashSet<>();
		}

		@Override
		public String toString() {

			return lvl + " " + val;
		}
	}

}
