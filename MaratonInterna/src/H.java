import java.io.*;
import java.util.*;

public class H {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			
			HashMap<String, String> hm = new HashMap<String, String>();
			String[] w = in.readLine().split(" ");
			
			for (int j = 0; j < w.length; j++) {
				
				StringBuilder act = new StringBuilder(w[j]);
				
				if (w[j].length() > 2) {

					char[] charArray = w[j].toCharArray();
					Arrays.sort(charArray);

					String cad = "";
					for (char c : charArray)
						cad += c + "";

					
					// String wAct = act.substring(1, w[j].length() - 1);

					 String clave = act.charAt(0) + "" + act.charAt(act.length() - 1) + "";
					 cad+=" "+clave;
					if (!hm.containsKey(cad)) {

						hm.put(cad, w[j]);

					}
				}
			}

			String[] d = in.readLine().split(" ");

			for (int j = 0; j < d.length; j++) {

				if (d[j].length() > 2) {
					 String first = (d[j].charAt(0) + "");
					 String last = d[j].charAt(d[j].length() - 1) + "";
				//	 String cAct = first + last;

					char[] charArray = d[j].toCharArray();
					Arrays.sort(charArray);
					String cad = "";
					for (char c : charArray)
						cad += c + "";

					cad+=" "+first+last;
					if (hm.containsKey(cad))
						System.out.print(hm.get(cad));
					else
						System.out.print(d[j]);
				} else {
					System.out.print(d[j]);
				}
				if (j + 1 != d.length)
					System.out.print(" ");
				else 
					System.out.println();
			}
		}

	}

}
