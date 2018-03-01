package CCPL;import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boiled {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {

			String[] caso = br.readLine().split(" ");

			int n = Integer.parseInt(caso[0]);
			int p = Integer.parseInt(caso[1]);
			int q = Integer.parseInt(caso[2]);

			String[] pesos = br.readLine().split(" ");
			int[] weight = new int[n];
			for (int j = 0; j < pesos.length; j++) {
				weight[j] = Integer.parseInt(pesos[j]);
			}

			Arrays.sort(weight);

			
			int acum = 0;
			int res = 0;
			for (int j = 0; j < weight.length; j++) {

				if (res+1 <= p && acum + weight[j] <= q) {
					res++;
acum+=weight[j];
				}else {
					break;
				}
			}
			bw.write("Case "+i+": "+ res+"\n");
			

		}

		bw.close();

	}

}
