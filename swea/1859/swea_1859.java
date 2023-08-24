package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1859 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st1.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for (int i = 0; i < n ; i++) {				
				arr[i] = Integer.parseInt(st3.nextToken());
			}
			
			Long sum = 0L;
			int temp = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (temp < arr[i])
					temp = arr[i];
				else
					sum += temp - arr[i];
			}
			
			System.out.println("#" + tc + " " + Math.max(0, sum));
			
		}
		
		
	}
}
