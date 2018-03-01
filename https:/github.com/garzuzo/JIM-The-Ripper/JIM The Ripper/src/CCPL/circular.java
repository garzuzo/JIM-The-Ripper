package CCPL;import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class circular {

	static boolean[] sieve = new boolean[1000001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));
		sieve[0] = sieve[1] = true;

		for (int i = 2; i * i <= 1000000; i++) {

			if (!sieve[i]) {

				for (int j = i * i; j <= 1000000; j += i) {
					sieve[j] = true;
				}
			}
		}
		HashSet<Integer> circulares = new HashSet<Integer>();

		for (int i = 100; i <= 1000000; i++) {

			if (!sieve[i]) {
				boolean esCirc = esCircular(i);

				if (esCirc) {
					for (int j = 0; j < auxCirc.size(); j++) {
						circulares.add(auxCirc.get(j));
					}

				}
			}
		}
		String caso;
		while (!(caso = lect.readLine()).equals("-1")) {

			String[] act = caso.split(" ");
			int inf = Integer.parseInt(act[0]);
			int sup = Integer.parseInt(act[1]);
			int cont = 0;

			for (int circularAct : circulares) {

				if (circularAct >= inf && circularAct <= sup) {
					cont++;
				}
			}

			esc.write(cont == 0 ? "No Circular Primes.\n" : cont == 1 ? "1 Circular Prime.\n" : cont + " Circular Primes.\n");
		}
		esc.close();

	}

	static ArrayList<Integer> auxCirc;

	static boolean esCircular(int num) {

		String cadena = num + "";
		boolean esCircular = true;
		auxCirc = new ArrayList<Integer>();
		for (int i = 0; i < cadena.length(); i++) {
			int numAux = Integer.parseInt(cadena);
			auxCirc.add(numAux);

			if (sieve[numAux]) {

				esCircular = false;
				break;
			}

			StringBuilder cadenitaAux = new StringBuilder(cadena);
			cadenitaAux.deleteCharAt(0);
			cadenitaAux.append(cadena.charAt(0));
			cadena = cadenitaAux.toString();

		}
		return esCircular;

	}

}
