package day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_8320 {
	public static int countSquare(int k) {
		int count = 0;
		for (int i = 1; i <= k; i++) {
			if (k % i == 0) {
				int r = i;
				int c = k / i;
				if (r >= c)
					count++;
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i = 1; i <= n; i++) 
			result += countSquare(i);
		
		System.out.println(result);
	}

}
