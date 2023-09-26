package day0926;

import java.io.*;
import java.util.*;

public class boj_10971 {
	
	static class Node{
		int curr,next,cost;
		public Node(int curr, int next, int cost) {
			this.curr = curr;
			this.next = next;
			this.cost = cost;
		}
	}
	
	static int N, ans;
	static int[][] W;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		W = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		
		// 완전 탐색 기법을 활용하여 1번 도시 ~ N번 도시(for문 돌릴 때는 0 ~ N-1번 도시)에서 출발했을 때 비용이 가장 적게 드는 루트를 찾고자 한다.
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			search(i,i,0,1);
		}
			
		System.out.println(ans);
		
	}
	
	/* 
	 start -> 외판원이 처음 출발한 곳(태초마을)
	 curr -> 현재 외판원이 위치한 도시
	 sum -> 현재까지 외판원이 들인 비용
	 cnt -> 현재까지 외판원이 방문한 도시의 수
	*/
	static void search(int start, int curr, int sum, int cnt) {
		
		if(cnt == N) { // 외판원이 방문한 도시의 수가 N이라면, 즉 도시를 모두 방문했다면 -> 처음 출발한 도시로 되돌아 가야 하는데
			if (W[curr][start] == 0)  // 만약 되돌아 가는 길이 막혀있다면
				return; // 아쉽지만 해당 루트는 답이 될 수 없는 루트이다.
			ans = Math.min(ans, sum + W[curr][start]);
//			System.out.println("끝! 최종 값 -> "+ans  ); // 허접한 디버깅 1
			return;
		}
		
//		System.out.println("현재 위치 -> " + start); // 허접한 디버깅 2
		
		for (int next = 0; next < N; next++) { 		// 다음 도시 방문할 도시를 물색해보자
			if(W[curr][next] == 0 || visited[next]) // 만약 가는 길이 없거나 이미 방문한 도시라면
				continue; 							// 경우의 수에서 배제한다.
			visited[next] = true;					// 만약 갈 수 있다면 방문 처리를 해주고
			search(start, next, sum + W[curr][next],cnt + 1); 	// 재귀를 시작한다.
			visited[next] = false;					// 위 재귀가 끝났을 경우를 대비하여 방문 처리 해제
		}
		
		
	}
	
	
	
}
