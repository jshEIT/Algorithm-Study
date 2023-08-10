package day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[]arr = new int[str.length()];
		
		for (int i = 0; i < arr.length; i++) 
			arr[i] = str.charAt(i) - '0';
		
		int one = 0;
		int zero = 0;
		
		if (arr[0] == 1)
			one++;
		else
			zero++;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] != arr[i]) {
				if (arr[i-1] == 1)
					zero++;
				else
					one++;
			}
		}
		System.out.println(Math.min(one, zero));
	}
}
