import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class D {

	static boolean[] memo;
	static long[] calc;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String act;

		while ((act = in.readLine()) != null) {

			String[] cAct = act.split(" ");

			long[] arr = new long[cAct.length];
			for (int i = 0; i < cAct.length; i++) {
				arr[i] = Long.parseLong(cAct[i]);
			}
			
			memo=new boolean[cAct.length];
			calc=new long[cAct.length];
			Arrays.fill(calc, Integer.MIN_VALUE);
			
			long max=Integer.MIN_VALUE;
			
			for (int i = 0; i < arr.length; i++) {
				
				max=Math.max(dp(arr,i),max);
				
			}
			
			if(max<0) {
				System.out.println(0);
			}else
				System.out.println(max);

		}
	}

	static long dp(long[] arr, int i) {

		if (i == 0)
			return arr[0];

		if (memo[i])
			return calc[i];

		long max = Math.max(arr[i], arr[i] + dp(arr, i - 1));

		calc[i] = max;
		memo[i] = true;
		return calc[i];
	}
}
