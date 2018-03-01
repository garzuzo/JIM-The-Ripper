package CCPL;import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.TreeSet;

public class commando {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String caso;
		int numCaso = 1;
		while (!(caso = br.readLine()).equals("0")) {
			int n = Integer.parseInt(caso);
			
			TreeSet<task> tasks = new TreeSet<>();
			
			for (int i = 0; i < n; i++) {
				String [] val = br.readLine().split(" ");
				
				tasks.add(new task(val[0], val[1]));
				
			}
			
			int b = 0;
			int j = 0;
			
			for (task tk: tasks) {
				b+= tk.b;
				j = j < b+tk.j?b+tk.j:j;
			}
			
			
			int ans = j;
			bw.write("Case " + numCaso + ": " + ans+ "\n");
			numCaso++;
		}
		bw.close();
	}
	
	static class task implements Comparable<task>{
		int b;
		int j;
		
		task(String b, String j){
			this.b = Integer.parseInt(b);
			this.j = Integer.parseInt(j);
		}
		
		task (int b, int j){
			this.b = b;
			this.j = j;
		}

		@Override
		public int compareTo(task arg0) {
			return arg0.j!=j?arg0.j-j:b-arg0.b;
		}
		
		
	}

}
