package day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2839 {
	public static final int MAX_N = 5000;
	public static int[] dp = new int[MAX_N + 1]; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp[3] = 1;
		dp[5] = 1;
		
		for (int i = 6; i <= n; i++) {
			if (dp[i-3] != 0)
				dp[i] = dp[i - 3] + 1;
			if (dp[i-5] != 0)
				dp[i] = dp[i - 5] + 1;
			if (dp[i-3] != 0 && dp[i-5] != 0)
				dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
		}
		if (dp[n] == 0)
			System.out.println(-1);
		else
			System.out.println(dp[n]);
		
	}

}
