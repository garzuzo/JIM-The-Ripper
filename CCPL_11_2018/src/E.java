import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class E {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line= in.readLine();
		int m= Integer.parseInt(line);
		
		double[] array= new double[m*2];
		
		double sumLeft=0;
		double sumRight=0;
		String[] data= in.readLine().split(" ");
		
		for(int i=0; i< array.length; i++){		
			array[i] = Double.parseDouble(data[i]);
			if(i < m)
			sumLeft+= array[i];
			else
			sumRight+= array[i];
		}
		
		double answer=0;
		if(sumRight> sumLeft){
			
			int cont=1;
			for(int i=m; i< array.length; i++ ){
				answer+= (cont*array[i]);
				cont++;
			}
			int cont2= ((cont-1)*2)+1;
			for(int j=m-1; j>=0; j--){
				answer += (cont2*array[j]);
				cont2++;
			}
		}
		else{
			
			int cont=1;
			for(int j=m-1; j>=0; j--){
				answer += (cont*array[j]);
				cont++;
			}
			int cont2= ((cont-1)*2)+1;
			for(int i=m; i< array.length; i++ ){
				answer+= (cont2*array[i]);
				cont2++;
			}
		}
		
		DecimalFormat df = new DecimalFormat("0.000000");

		out.write(df.format(answer) + "\n");
		out.close();
	}

}
