import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class K {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String dat = in.readLine();
		
		while (dat != null && !dat.isEmpty()) {
			
			String k = dat;
			
			String[] dats = in.readLine().split(" ");
			
			int cant = 0;
			
			for (String v : dats) {
				if (k.equals(v)) {
					cant++;
				}
			}
			
			out.write(cant + "\n");
			
			dat = in.readLine();
		}
		
		
		out.close();
		
	}
	
}
