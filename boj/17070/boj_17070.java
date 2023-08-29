package day0829;

import java.io.*;
import java.util.*;

public class boj_17070 {
	static int N;
	static int[][]map;
	static int[][] visited;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visited = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,1,0);
		
		System.out.println(count);
		
	}
	
	
	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
	
	// 현재 좌표 r,c, 현재 방향의 상태 dir
	static void dfs(int r, int c, int dir) {
		// 배열을 벗어나거나 갈 수 없는 곳일 경우
		if (!inRange(r,c) || map[r][c] == 1 )
			return;
		
		// 목적지에 도착하면 count 1 증가
		if (r == N - 1 && c == N - 1) {
			count++;
			return;
		}
		
		
		// 가로 방향일 때
		if (dir == 0) {
			// 이동할 수 있는 방법으로 이동 - 방향은 유지
			dfs(r,c+1,0); // 가로로 이동
			if (inRange(r,c+1) && inRange(r+1,c+1) && inRange(r+1,c) && map[r][c+1] == 0 && map[r+1][c+1] == 0 && map[r+1][c] == 0) // 대각으로  회전이 가능하고 이동할 수 있다면
				dfs(r+1,c+1,1); // 대각으로 이동
		}
		
		// 대각선 방향일 때
		if (dir == 1) {
			// 이동할 수 있는 방법으로 이동
			dfs(r,c+1,0); // 가로로 
			if (inRange(r,c+1) && inRange(r+1,c+1) && inRange(r+1,c) &&  map[r][c+1] == 0 && map[r+1][c+1] == 0 && map[r+1][c] == 0) // 대각으로 회전이 가능하고 이동할 수 있다면
				dfs(r+1,c+1,1); // 대각으로  이동
			dfs(r+1,c,2); // 세로로 이동
		}
		
		// 세로 방향일 때
		if (dir == 2) {
			// 이동할 수 있는 방법으로 이동
			dfs(r+1,c,2); // 세로로
			if (inRange(r,c+1) && inRange(r+1,c+1) && inRange(r+1,c) && map[r][c+1] == 0 && map[r+1][c+1] == 0 && map[r+1][c] == 0) // 대각으로 이동할 수 있다면
				dfs(r+1,c+1,1); // 대각으로
			
		}

			
	}

}
