package day0824;

import java.io.*;
import java.util.*;

public class swea_1974 {
	static int[][] arr2d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			arr2d = new int[9][9];
			// 배열 채우기
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++)
					arr2d[i][j] = Integer.parseInt(st.nextToken());
			}
			
			boolean isSudoku = true;

			for (int i = 0; i < 9; i++) {
				int rowSum = 0;
				int colSum = 0;
				int squareSum = 0;
				for (int j = 0; j < 9; j++) {
					rowSum += arr2d[i][j];
					colSum += arr2d[j][i];
					squareSum = 0;
					for (int x = (i / 3)*3; x < (i / 3)*3 + 3; x++)
						for (int y = (j / 3)*3; y <(j / 3)*3 + 3; y++)
							squareSum += arr2d[x][y];
				}
				if (rowSum != 45 || colSum != 45 || squareSum != 45) {
					isSudoku = false;
					break;
				}
			}
			
			if (isSudoku)
				System.out.println("#" + tc + " " + 1);
			else
				System.out.println("#" + tc + " " + 0);
					
		}
			
			
			
	}
		
		
		
}

