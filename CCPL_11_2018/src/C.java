import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] pass = new int[11];
		
		pass[1] = 4;
		pass[2] = 6;
		
		for (int i = 3; i < pass.length;){
			String mult = pass[i-1]*pass[i-2] + "";
			for (int j = 0; j < mult.length(); j++){
				pass[i] = mult.charAt(j)-'0';
				i++;
			}
			
		}
		
		String [] dat = in.readLine().split(" ");
		
		for (String val : dat){
			int v = Integer.parseInt(val);
			v = v<3?v:(v-2)%8 == 0?(v-2)%8+10:(v-2)%8+2;
			out.write(pass[v] + "");
		}
		
		out.write("\n");
		
		out.close();

	}

}
