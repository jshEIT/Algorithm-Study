package boj;

import java.io.*;
import java.util.*;

public class boj_12865 {
	
	static int N,K;
	static int[] weights,values;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		weights = new int[N + 1];
		values = new int[N + 1];
		dp = new int[N + 1][K + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			weights[i] = W;
			values[i] = V;
		}
		/*
		 dp[i][j] -> i번째 보석을 골랐을 때 무게 합이 j인 경우
		 i번째 보석을 넣는 경우와 넣지 않는 경우를 구분해서 점화식을 세울 수 있다.
		 <i번째 보석을 넣는 경우>
		 i-1번째 보석까지 골라진 보석의 무게의 합 : j - weight[i]
		 이 경우 이전에 선택한 보석들로부터 얻을 수 있는 최대 가치인 dp[i-1][j-weight[i]]에 
		 현재 i번째 보석의 가치인 valuse[i]를 더하여
		 dp[i][j] = dp[i-1][j-weight[i]] + values[i]를 구할 수 있다.
		 다만 위 경우는 j >= weigth[i]인 경우에만 성립이 가능하다.
		 
		 <i번째 보석을 넣지 않는 경우>
		 i번째 보석을 선택하지 않았으므로 i-1번째까지 골라진 보석의 합이 정확하게 j가 되어야 한다.
		 따라서 dp[i][j] = dp[i-1][j]이다.
		 */
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j >= weights[i]) {
					dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i - 1][j]);
				}
				else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}
}
