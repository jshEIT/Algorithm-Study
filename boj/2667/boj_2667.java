package day0821;

import java.io.*;
import java.util.*;

public class boj_2667 {
	static final int MAX_N = 25;
	static int[][] map= new int [MAX_N + 1][MAX_N + 1];
	static int[][] visited = new int[MAX_N + 1][MAX_N + 1];
	static int N;
	static int num = 1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine().trim());
		
		// 지도 입력
		for (int i = 0; i < N; i++) {
			String str[] = br.readLine().split("");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//  집이 있는 곳이고		    아직 방문하지 않은 곳이라면
				if (map[i][j] == 1 && visited[i][j] == 0) {
					DFS(i,j); // DFS실시
					num++; // 아파트 단지 숫자 증가
				}
			}
		}
		
		int[] ans = new int[num]; // 각 단지의 수를 넣을 배열 선언
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) // map을 순회하면서
				if (map[i][j] != 0) // 0이 아닌 곳(집이 아닌 곳)을 제외한 숫자를
					ans[map[i][j]]++; // ans 배열에 기록 -> 마치 counting sort처럼
		}
				
		
		Arrays.sort(ans); // 오름차순으로 정렬해야 한다 -> 안 그러면 3%에서 오답

		sb.append(num-1).append("\n");
		for (int i = 1; i < num; i++)
			sb.append(ans[i]).append("\n");
		System.out.println(sb);
		
	}
	
	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
	
	static void DFS(int r, int c) {
		// 범위 밖이거나 			 이미 방문했거나			       갈 수 없는 곳이라면
		if (!inRange(r,c) || visited[r][c] == 1 || map[r][c] == 0)
			return; // 중단
		
		visited[r][c] = 1; // 방문처리
		map[r][c] = num; // 1 -> num으로 바꾸기
		
		DFS(r, c + 1);
		DFS(r + 1, c);
		DFS(r, c - 1);
		DFS(r - 1,c);
	}
	
}
