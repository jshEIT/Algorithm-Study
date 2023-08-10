package day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2001 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 숫자를 넣을 배열
			int arr2d[][] = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr2d[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum = 0;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int temp = 0;
					for (int x = 0; x < M; x++) {
						for (int y = 0; y < M; y++) {
							temp += arr2d[x + i][y + j];
						}
					}
//					System.out.println(temp);
					if (temp > sum)
						sum = temp;
				}
			}
			
			System.out.println("#" + tc + " " + sum);
			
		}
		
		
		
		
		
		
		
		
	}
}
