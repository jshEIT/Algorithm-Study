package day0830;

import java.io.*;
import java.util.*;

public class swea_2817 {
	static int N,K,count;
	static int[] arr;
	static int [] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			visited = new int[N];
			count = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {				
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			getSum(0,0);
			
			System.out.println("#" + tc + " " + count);
			
		}
				
	}
	
	static void getSum(int d, int sum) {
		if (sum == K) {
			count++;
			return;
		}
		else if (d >= N  || sum > K)
			return;
				
		getSum(d + 1, sum + arr[d]); // 현재 원소 포함 O
		getSum(d + 1, sum); // 현재 원소 포함 X
		
		
		
			
	}
	
	
}
