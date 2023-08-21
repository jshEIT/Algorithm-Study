package day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// This code is written based on the answer from https://www.acmicpc.net/board/view/118149

public class boj_2615_right {
	public static int n;
	public static int[][] arr2d = new int[19][19];
	
	public static int[] dr = {0,1,1,-1};
	public static int[] dc = {1,0,1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++)
				arr2d[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (arr2d[i][j] != 0)
					solution(i,j,arr2d[i][j]);
			}
		}
		
		System.out.println(0);
		
		
		
	}
	
	public static boolean inRange(int r, int c) {
		return 0 <= r && r < 19 && 0 <= c && c < 19;
	}
	
	public static void solution (int sr, int sc, int color) {
		for (int i = 0; i < 4; i++) {
			int cnt = 1;
			int r = sr + dr[i];
			int c = sc + dc[i];
			while (inRange(r,c) && arr2d[r][c] == color) {
				cnt++;
				if (cnt == 5) {// 육목인 상황을 고려하자
					if (inRange(sr-dr[i],sc-dc[i]) && arr2d[sr-dr[i]][sc-dc[i]] == color)// 
						break;
					if (inRange(r+dr[i],c+dc[i]) && arr2d[r+dr[i]][c+dc[i]] == color) // 진행방향에 알이 하나 더 있을 경우
						break;
					
					System.out.println(color);
					System.out.println((sr + 1) + " " + (sc + 1));
					System.exit(0);
				}
				r += dr[i];
				c += dc[i];
				
			}
		}
	}
	
}
