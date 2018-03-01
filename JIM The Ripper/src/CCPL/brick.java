package CCPL;import java.io.*;
import java.util.*;

public class brick {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner lect = new Scanner(System.in);
		int caso;
		HashMap<Integer, Long> persis = new HashMap<Integer, Long>();
		long[] arr = new long[51];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		for (int i = 4; i < 51; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		while ((caso = lect.nextInt()) != 0) {

			System.out.println(arr[caso]);

		}
	}

}
