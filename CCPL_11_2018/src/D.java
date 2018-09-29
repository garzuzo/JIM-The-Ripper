import java.io.*;
import java.text.DecimalFormat;

public class D {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] caso = in.readLine().split(" ");

		int n = Integer.parseInt(caso[0]);
		int m = Integer.parseInt(caso[1]);

		double ret = (m) + (0.5 * (n - m - 1));

		DecimalFormat df = new DecimalFormat("0.0");

		out.write(df.format(ret) + "\n");
		out.close();
	}

}
