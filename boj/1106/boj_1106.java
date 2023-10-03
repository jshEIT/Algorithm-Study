package boj;

import java.io.*;
import java.util.*;

public class boj_1106 {
	
	static int C,N;
	static int[] people;
	static int[] costs;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		people = new int[N + 1];
		costs = new int[N + 1];
		dp = new int[C + 101];
		
		// dp의 각 초깃값을 아주 큰 값으로 초기화
		for (int i = 1; i < dp.length; i++)
			dp[i] = 1000000;
		
		dp[0] = 0;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			costs[i] = Integer.parseInt(st.nextToken());
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		/* 
		최소 C명 이상 유치하기 위한 최소 비용을 구하는 것이지만
		C명보다 더 많은 인원을 유치할 때 얼마든지 최소비용이 나올 수 있다.
		이는 예제 2번에서 확인할 수 있는데,
		dp[10] = 6(1 + 1 + 1 + 3)이지만
		dp[12] = 4(1 + 1 + 1 + 1)로
		최소인원인 10명을 유치하는 것보다 12명을 유치할 때 비용이 더 적게 든다는 사실을 알 수 있다.
		따라서 딱 C명일 때 뿐만 아니라 C보다 많은 고객 수 -> C + 100명 이하로 유치했을 때 최소 비용이 존재하는지 또한 찾아봐야 한다.
		*/
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < C + 101; j++) { // j = 1 -> j = people[i]로 하면 코드를 줄일 수 있다.
				if (j >= people[i])
					dp[j] = Math.min(dp[j], costs[i] + dp[j - people[i]]);
			}
		}
		
		
		int ans = 1000000;
		
		// C명(최소 유치 인원) ~ C + 100명까지 루프를 돌면서 C일때보다 더 작은 값이 있는지 찾아본다.
		for (int i = C; i < C + 101; i++)
			ans = Math.min(ans, dp[i]);
		
		System.out.println(ans);
		
	}
}
