package ICPC;import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class F {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++){
			
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			boolean [][] ver = new boolean [r][c];
			boolean [][] libres = new boolean [r][c];
			
			char [][] mapa = new char [r][c];
			
			sc.nextLine();
			
			for (int j = 0; j < r; j++){
				mapa[j] = sc.nextLine().toCharArray();
			}
			
			for (int k = 0; k < c; k++){
				if (!ver[0][k]){
					verificar(ver, libres, mapa, 0, k);
				}
			}
			for (int k = 0; k < c; k++){
				if (!ver[r-1][k]){
					verificar(ver, libres, mapa, r-1, k);
				}
			}
			for (int k = 0; k < r; k++){
				if (!ver[k][0]){
					verificar(ver, libres, mapa, k, 0);
				}
			}
			for (int k = 0; k < r; k++){
				if (!ver[k][c-1]){
					verificar(ver, libres, mapa, k, c-1);
				}
			}
			
			int lib = 0;
			
			for (boolean [] lin : libres){
				for (boolean bol: lin){
					if (bol){
						lib++;
					}
				}
			}
			
			bw.write(lib + "\n");
			
		}
		
		bw.close();
		
	}
	
	static void verificar (boolean [][] ver, boolean[][] libres, char [][] mapa, int i, int j){
					
		ver[i][j] = true;
		if (mapa[i][j] == '0'){
			
			libres[i][j] = true;
			
			if (i+1 < mapa.length && !ver[i+1][j]){
					verificar(ver, libres, mapa, i+1, j);					
			}

			if (i-1 >= 0 && !ver[i-1][j]){
					verificar(ver, libres, mapa, i-1, j);					
			}
			

			if (j+1 < mapa[0].length && !ver[i][j+1]){
					verificar(ver, libres, mapa, i, j+1);					
			}
			

			if (j-1 >= 0 && !ver[i][j-1]){
					verificar(ver, libres, mapa, i, j-1);					
			}

		}
		
	}

}
