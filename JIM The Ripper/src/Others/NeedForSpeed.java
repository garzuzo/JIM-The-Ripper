package Others;

import java.io.*;
import java.util.*;

public class NeedForSpeed {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));

		
		int[] arr=new int[3];
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min=Math.min(min, arr[i]);
		}
		binarySearch(arr, 0, min, 100000001);
	}

	static long binarySearch(int[] arr, int l, int r, int x) {

		if (r >= l) {
			int mid = l + (r - 1) / 2;
			if (arr[mid] == x)
				return mid;
			else if (arr[mid] > x)
				return binarySearch(arr, l, mid - 1, x);
			else
				return binarySearch(arr, mid + 1, r, x);

		}
		return -1;
	}

}
