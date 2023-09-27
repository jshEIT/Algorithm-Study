package day0927;

import java.io.*;
import java.util.*;

public class boj_1149 {
	
	static int[][] dp;
	static int[][] rgb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		
		rgb = new int[N + 1][3];
		dp = new int[N + 1][3];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				rgb[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 필요한 정보를 역으로 추적
		for(int i = 1; i <= N; i++) {
			// 상황 별로 마지막 벽이 각각 R,G,B인 경우
			dp[i][0] = Math.min(dp[i - 1][1],dp[i - 1][2]) + rgb[i][0]; // 마지막 벽이 R - 직전의 벽이 G,B인 것인 중 가장 작은 값
			dp[i][1] = Math.min(dp[i - 1][0],dp[i - 1][2]) + rgb[i][1]; // 마지막 벽이 G - 직전의 벽이 R,B인 것인 중 가장 작은 값
			dp[i][2] = Math.min(dp[i - 1][0],dp[i - 1][1]) + rgb[i][2]; // 마지막 벽이 B - 직전의 벽이 R,G인 것인 중 가장 작은 값
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}

}
