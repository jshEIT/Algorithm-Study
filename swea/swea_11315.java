package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_11315 {
	public static final int MAX_N = 20;
	// 8방탐색
	public static int[] dr = new int[] {-1,0,1,1,1,0,-1,-1};
	public static int[] dc = new int[] {1,1,1,0,-1,-1,-1,0};
	
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
			
			int[][] arr = new int[MAX_N][MAX_N];
			
			// 배열 만들기
			// 숫자 배열로 바꿔주기 o -> 1  . -> 0
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					char temp = str.charAt(j);
					if (temp == 'o')
						arr[i][j] = 1;
					else
						arr[i][j] = 0;
				}
			}
			
			
			boolean isOmok = false; 
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					// 해당 좌표가 1이면
					if (arr[r][c] == 1) {
						// 8방탐색 시작
						int repeat = 0; // 반복 횟수 기록 -> 5번이면 멈춤
//						int count = 1; // 여기서 count = 1로 초기화하게 되면 while문을 도는 족족 count++이 된다. (2차 오답 원인)
						int i = r, j = c;
						for (int k = 0; k < 8; k++) {
							int count = 1; // 여기서 count = 1로 초기화 해야한다.
							while (repeat <= 5) {
								int nr = i + dr[k];
								int nc = j + dc[k];
								
								// 범위를 벗어나거나 돌이 1이 아닌 경우 멈추기
								if (!inRange(nr,nc,n) || arr[nr][nc] == 0) {
									break;
								}
									
								i = i + dr[k];
								j = j + dc[k];
								count++; // 이걸 안 써서 1차 오답
							}
							
							if(count == 5) {
								isOmok = true;
								break;
							}
						}
					}
				
				}
			}
			
			if (isOmok)
				System.out.println("#" + tc + " YES");
			else
				System.out.println("#" + tc + " NO");
			
			
			
			
			
			
			
			
			
			
			
			
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
						
		}
		
		
		
	}
}
