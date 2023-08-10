package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1209 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			
			// 행 별 합
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				if (sum > max)
					max = sum;
			}
			
			// 열 별 합
			for (int j = 0; j < 100; j++) {
				int sum = 0;
				for (int i = 0; i < 100; i++) {
					sum += arr[i][j];
				}
				if (sum > max)
					max = sum;
			}
			
			// 대각선 합
			int r1 = 0, c1 = 0;
			int sum1 = 0;
			while (r1 <= 99 && c1 <= 99) {
				sum1 = arr[r1++][c1++];
			}
			
			if (sum1 > max)
				max = sum1;
			
			int r2 = 0, c2 = 99;
			int sum2 = 0;
			while (r2 <= 99 && c2 >= 0) {
				sum2 = arr[r2++][c2--];
			}
			
			if (sum2 > max)
				max = sum2;
			
			System.out.println("#" + tc + " " + max);
			
			
			
		}
		
	}
}
