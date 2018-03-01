package CCPL;import java.io.*;
import java.util.*;

public class price {

	static HashMap<Integer, Long> hm;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));
		
		hm = new HashMap<Integer, Long>();

		hm.put(0, 0l);
		
		
		
		String caso;
		while ((caso = lect.readLine()) != null) {

			String[] act = caso.split(" ");

			int nAct = Integer.parseInt(act[0]);

			if (nAct == 0) {
				esc.write("1\n");
			}else {
				
				if (act.length == 1) {
					if (hm.containsKey(nAct)) {
						esc.write(hm.get(nAct) + "\n");
					} else {
						int[] S = new int[Integer.parseInt(act[0])];
						for (int i = 0; i < S.length; i++) {
							S[i] = i + 1;
						}
						long resAct = countWays(S, S.length, S.length);
						hm.put(nAct, resAct);
						esc.write(resAct + "\n");
					}
				} else if (act.length == 2) {
					
					int[] S = new int[nAct];
					int l = Integer.parseInt(act[1]);
					l = S.length < l? S.length: l;
					for (int i = 0; i < S.length; i++) {
						S[i] = i + 1;
					}
					esc.write(countWays(S, l, S.length) + "\n");
					
				} else {
					
					int[] S = new int[nAct];
					int l1 = Integer.parseInt(act[1]);
					int l2 = Integer.parseInt(act[2]);
					if (l1 > nAct) {
						esc.write("0\n");
					}else {
						l1 = S.length < l1? S.length: l1;
						l2 = S.length < l2? S.length: l2;
						for (int i = 0; i < S.length; i++) {
							S[i] = i + 1;
						}
						esc.write((countWays(S, l2, S.length) - countWays(S, l1 - 1, S.length)) + "\n");						
					}
					
				}
			}
			

		}
		esc.flush();

	}


	static long countWays(int S[], int m, int n) {

		long[] table = new long[n + 1];

		table[0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = S[i]; j <= n; j++) {
				table[j] += table[j - S[i]];
			}
		}

		// for (int i = 0; i <= n; i++) {
		// System.out.println(table[i]);
		// }
		return table[n];

	}
}
