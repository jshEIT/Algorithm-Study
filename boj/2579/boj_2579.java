package day0927;

import java.io.*;
import java.util.*;

public class boj_2579 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] dp = new int[300 + 1];
		int[] stairs = new int[300 + 1];
		for (int i = 1; i <= N; i++)
			stairs[i] = Integer.parseInt(br.readLine().trim());
		
		
		dp[1] = stairs[1];
		dp[2] = stairs[1] + stairs[2];
		
		for (int i = 3; i <= N; i++)
			// 현재 계단  + max(두 계단 전까지 누적합 vs 세 계단 전까지 누적합 + 이전 계단)
			// dp[i-1]이 없는 이유? -> 연속으로 두 계단을 오른 경우도 있을 수 있기 때문 
			// -> n = 3인 경우를 생각해보자. dp[2]만 하더라도 두 계단을 동시에 오른 값의 합이다. -> dp[3]은 dp[2] + stairs[3]이 될 수 없다.
			dp[i] = stairs[i] + Math.max(dp[i-2], dp[i-3] + stairs[i-1]);
		
		System.out.println(dp[N]);
	}

}
