package day0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
1
14
0 0 3 5 2 4 9 0 6 4 0 6 0 0 
 * */



public class swea_1206 {
	public static final int MAX_N = 1000;
	public static final int T = 10;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[MAX_N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int total = 0;
			
			// 맨 왼쪽 2칸, 오른쪽 두 칸은 공실
			for (int i =2; i < n-2; i++) {
				int possible = arr[i];
				int max1 = possible - Math.max(arr[i-1], arr[i+1]);
				int max2 = possible - Math.max(arr[i-2],arr[i+2]);
				int temp = Math.min(max1, max2);

				if (temp<= 0)
					continue;
				total += temp;
//				System.out.println(temp + " " + total);
			}
			
			System.out.println("#" + tc + " " + total);
			
		}
	}
}
