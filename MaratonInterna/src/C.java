import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;


public class C {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String dat[] = in.readLine().split(" ");

		int n = Integer.parseInt(dat[0]);
		int b = Integer.parseInt(dat[1]);

		while (n != 0 && b != 0) {

			HashMap<Integer, HashMap<Integer, Integer>> v = new HashMap<>();
			
			for (int c = 0; c < b; c++) {
				dat = in.readLine().split(" ");
				int i = Integer.parseInt(dat[0])-1;
				int j = Integer.parseInt(dat[1])-1;
				int w = Integer.parseInt(dat[2]);
				
				if (!v.containsKey(i)) {
					v.put(i, new HashMap<>());
				}
				
				if (!v.containsKey(j)) {
					v.put(j, new HashMap<>());
				}
				
				v.get(i).put(j, w);
				v.get(j).put(i, -w);
				
			}
			
			boolean [] visit = new boolean[n];
			
			PriorityQueue<q> que = new PriorityQueue<>();
			
			boolean posible = false;
			
			que.add(new q(0));
			
			while (!que.isEmpty()) {
				q actual = que.remove();
				if (!visit[actual.i]) {
					visit[actual.i] = true;
					
					if (v.containsKey(actual.i)) {
						for (int j: v.get(actual.i).keySet()) {
							if (j == 0) {
								
								//System.out.println("ciclo");
								
								int w = actual.w + v.get(actual.i).get(j);
								if (w != 0 ) {
									posible = true;
									break;
								}
							}else {
								if (!visit[j]) {
									que.add(new q(j, actual.w + v.get(actual.i).get(j)));
								}
							}
						}
					}
					
				}
				
			}
			
			if (posible) {
				out.write("Y\n");
			}else {
				out.write("N\n");
			}

			dat = in.readLine().split(" ");

			n = Integer.parseInt(dat[0]);
			b = Integer.parseInt(dat[1]);
		}

		out.close();

	}

	static class q implements Comparable<q> {
		int w;
		int i;
		
		public q(int i) {
			this.i = i;
		}
		
		public q(int i, int w) {
			this.i = i;
			this.w = w;
		}

		@Override
		public int compareTo(q o) {
			return this.w != o.w ?this.w - o.w: i-o.i;
		}

	}

}
