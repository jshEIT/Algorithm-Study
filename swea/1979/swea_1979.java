package day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class swea_1979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr2d = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr2d[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//총합
			int sum = 0;
			
			// 가로 돌면서 맞는 길이 찾기
			for (int i = 0; i < N; i++) {
				int tempL = 0;
				for (int j = 0; j < N; j++) {
					if (arr2d[i][j] == 1) 
						tempL++;
					else
						tempL = 0;
					if (j < N-1 && arr2d[i][j+1] == 0 && tempL == K) {
						sum++;
						tempL = 0;
					}
						
				}
//				System.out.println(tempL);
				if (tempL == K)
					sum++;
			}
			
//			System.out.println();
			
			// 세로 돌면서 맞는 길이 찾기
			for (int j = 0; j < N; j++) {
				int tempL = 0;
				for (int i = 0; i < N; i++) {
					if (arr2d[i][j] == 1)
						tempL++;
					else
						tempL = 0;
					if (i < N-1 && arr2d[i+1][j] == 0 && tempL == K) {
						sum++;
						tempL = 0;
					}

				}
//				System.out.println(tempL);
				if (tempL == K)
					sum++;
			}
			
			System.out.println("#" + tc + " " + sum);
			
		}

	}

}