import java.io.*;
import java.util.*;

public class F {

	static int cards[] = { 1, 10, 100, 1000, 10000 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String caso;
		while ((caso = in.readLine()) != null) {

			String[] qAct = caso.split(" ");

			int n = Integer.parseInt(qAct[0]);
			int q = Integer.parseInt(qAct[1]);
			int max = 0;
			int rest = 0;
			for (int i = 0; i < q; i++) {

				String act[] = in.readLine().split(" ");

				int b = Integer.parseInt(act[0]);
				int dae = Integer.parseInt(act[1]);
				int sum = 0;
				for (int j = 2; j < n+1; j++) {
					int cAct = Integer.parseInt(act[j]);
					sum += cAct;
				}

				int sum1 = sum;
				if (b - sum > 0) {

//					sum = b - sum;

					int cont = 0;
					for (int j = 0; j < cards.length; j++) {

						if (sum + cards[j] <= b) {
							cont = j;
						} else {
							break;
						}

					}

					max += cards[cont];
				}
				sum1 += dae;
				if (sum1 <= b) {
					rest += dae;
				}
			}
			System.out.println(max - rest);
		}

	}

}
