import java.io.*;
import java.util.*;

public class E {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String dat[] = in.readLine().split(" ");
		
		int n = Integer.parseInt(dat[0]);
		int m = Integer.parseInt(dat[1]);
		
		int c = 1;
		
		while (n != 0 && m != 0) {
			
			UF uf = new UF(n);
			
			for (int i = 0; i < m; i++) {
				dat = in.readLine().split(" ");
				int o = Integer.parseInt(dat[0])-1;
				int f = Integer.parseInt(dat[1])-1;
				uf.union(o, f);
			}
			
			out.write("Case " + c + ": " + uf.g + "\n");
			
			dat = in.readLine().split(" ");
			
			n = Integer.parseInt(dat[0]);
			m = Integer.parseInt(dat[1]);
			c++;
		}
		
		out.close();
		
	}
	
	static class UF {
		int [] p;
		int g;
		
		public UF(int n) {
			g = n;
			p = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
			}
		}
		
		void union(int i, int j) {
			
			if (!isSameSet(i, j)) {
				g--;
				p[find(i)] = find(j);
			}
			
		}
		
		boolean isSameSet(int i, int j) {
			return find(i) == find(j);
		}
		
		int find(int i) {
			if (p[i] == i) {
				return i;
			}else {
				int par = find(p[i]);
				p[i] = par;
				return par;
			}
		}
		
	}

}
