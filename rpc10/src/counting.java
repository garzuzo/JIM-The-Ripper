import java.io.*;

import java.util.*;

public class counting {

	static long mod = (long) (1000000007);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] table = new long[10002];

		table[0] = 1;
		int arr[] = new int[10002];
		for (int i = 0; i < 10002; i++) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < 10002; i++)
			for (int j = arr[i]; j <= 10001; j++) {
				int num = arr[i];
				table[j] += table[j - num];
				table[j] %= mod;
			}

		String c;
		while ((c = in.readLine()) != null) {

			int n = Integer.parseInt(c);
//System.out.println(table[n]);
			out.write(table[n] + "\n");

		}
out.close();
	}

}
