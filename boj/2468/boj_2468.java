package day0822;

import java.io.*;
import java.util.*;

public class boj_2468 {
	static final int MAX_N = 100;
	static int N;
	
	static int[][] map1 = new int[MAX_N][MAX_N];
	static int[][] map2;
	static int[][] visited;
	
	static int[] dr = new int[] {0,1,0,-1};
	static int[] dc = new int[] {1,0,-1,0};
	
	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
	
	static boolean canGo(int r, int c,int[][] map) {
		return inRange(r,c) && map[r][c] == 1 && visited[r][c] == 0;
	}
	
	static void dfs(int r, int c,int[][]map) {
		if (!canGo(r,c,map))
			return;
		
		visited[r][c] = 1;
		
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			dfs(nr,nc,map);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		// map1(지역 높이 정보)입력 
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				map1[i][j] = Integer.parseInt(str[j]);
		}
		
		int max = 0; // 안전 영역의 최대 개수를 저장하기 위한 변수 max 선언
		
		for (int c = 1; c <= 100; c++) { // 높이가 1부터 100일 때를 따져가며 안전 영역의 개수를 구한다.
			map2 = new int[N][N];
			visited = new int[N][N];
			int count = 0;
			
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < N; j++) {
					if (map1[i][j] < c) // map1의 정보를 참고해서 
						map2[i][j] = 0; // map1의 특정 지역의 높이가 c보다 작을 때는 0을 map2에 입력(이 부분은 생략 가능)
					else
						map2[i][j] = 1; // map1의 특정 지역의 높이가 c보다 작지 않을 때는 1을 map2에 입력
				}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map2[i][j] == 1 && visited[i][j] == 0) {
						dfs(i,j,map2);
						count++;
					}
				}
			}
			
			if (count > max) // 안전 지역의 최대 개수를 갱신
				max = count; 
			
			
		}
		
		
		System.out.println(max);
		
		
		
	}
	
}
