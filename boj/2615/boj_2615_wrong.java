package day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 테스트 케이스는 맞지만 8%에서 틀린다.
// 답안 출력시 무조건 가장 왼쪽 좌표가 출력되어야 하지만
// 이 코드의 경우 시작점을 출력하는 것이므로 가장 왼쪽 좌표이 출력되지 않을 수 있기 때문이다.

public class boj_2615_wrong {
		public static int n;
		public static int[][] arr2d = new int[19][19];
//		public static int[] dr = {-1,-1,-1,0,1,1,1,0};
//		public static int[] dc = {-1,0,1,1,1,0,-1,-1};
		
//		public static int[] dr = {0,1,1,1,0,-1,-1,-1};
//		public static int[] dc = {1,1,0,-1,-1,-1,0,1};
		public static int[] dr = {0,1,1,-1};
		public static int[] dc = {1,0,1,1};
		
		public static boolean inRange(int r, int c) {
			return 0 <= r && r < 19 && 0 <= c && c < 19;
		}
		
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			int ansR = 0;
			int ansC = 0;
			
			for (int i = 0; i < 19; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 19; j++)
					arr2d[i][j] = Integer.parseInt(st.nextToken());
			}
			
			boolean blackWin = false; 
			boolean whiteWin = false;
			
			total : for (int i = 0; i < 19; i++) {
				for (int j = 0; j < 19; j++) {
					if (arr2d[i][j] == 1) { // 1일 때
						for (int d = 0; d < 4; d++) {
							int currR = i;
							int currC = j;

							int count = 1;
							while (true) { // 앞에 돌들 탐색
								int nr = currR + dr[d];
								int nc = currC + dc[d];
								if (!inRange(nr,nc) || arr2d[nr][nc] != 1)
									break;
								count++;
								currR += dr[d];
								currC += dc[d];
							}
							
							
							currR = i;
							currC = j;
							
							while (true) { // 뒤에 돌들도 탐색
								int nr = currR - dr[d];
								int nc = currC - dc[d];
								if (!inRange(nr,nc) || arr2d[nr][nc] != 1)
									break;
								count++;
								currR -= dr[d];
								currC = dc[d];
							}
							
							if (count == 5) {// 정확히 개수가 5개여야지만 오목
								blackWin = true;
								ansR = i + 1;
								ansC = j + 1;
								break total;
							}
						}
					}
					
					if (arr2d[i][j] == 2) { // 2일 때(흰색일 때)
						for (int d = 0; d < 4; d++) {
							int currR = i;
							int currC = j;

							int count = 1;
							while (true) {
								int nr = currR + dr[d];
								int nc = currC + dc[d];
								if (!inRange(nr,nc) || arr2d[nr][nc] != 2)
									break;
								count++;
								currR += dr[d];
								currC += dc[d];
							}
							
							currR = i;
							currC = j;
							
							while (true) {
								int nr = currR - dr[d];
								int nc = currC - dc[d];
								if (!inRange(nr,nc) || arr2d[nr][nc] != 2)
									break;
								count++;
								currR -= dr[d];
								currC -= dc[d];
							}
							
							if (count == 5) {// 정확히 개수가 5개여야지만 오목
								whiteWin = true;
								ansR = i + 1;
								ansC = j + 1;
								break total;
							}
						}
					}
					
					
				}
			} // total 끝
			
			if (blackWin) {
				System.out.println(1);
				System.out.println(ansR + " " + ansC);
			} else if (whiteWin) {
				System.out.println(2);
				System.out.println(ansR + " " + ansC);
			} else
				System.out.println(0);
				
			
			
			
		}
	
}
