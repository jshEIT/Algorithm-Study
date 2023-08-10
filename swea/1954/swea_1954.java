package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1954 {
	// 							     방향 -동  남 서  북
	public static int[] dr = new int[] {0,1,0,-1};
	public static int[] dc = new int[] {1,0,-1,0};
	public static boolean inRange(int x, int y, int n) {
		return (0 <= x && x < n && 0 <= y && y < n);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			// 숫자 넣을 배열 초기화
			int[][] arr = new int[10][10];
			
			// 초기 좌표 (0,0)
			int r = 0, c = 0;
			
			// (0,0)에 값 넣어주기
			arr[r][c] = 1;
			
			// 초기 방향 -> 동쪽을 바라보게끔
			int dir = 0;
			
			for (int i = 2; i <= n * n; i++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if (!inRange(nr,nc,n) || arr[nr][nc] != 0)
					dir = (dir + 1) % 4;
				
				r = r + dr[dir];
				c = c + dc[dir];
				arr[r][c] = i;
			}
				
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

			
		}
	}
}
