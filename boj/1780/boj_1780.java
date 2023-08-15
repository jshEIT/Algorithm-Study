package day0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1780 {
	public static final int MAX_N = 2187;
	public static int minusOne = 0;
	public static int zero = 0;
	public static int one = 0;
	
	public static int[][] arr2d = new int[MAX_N + 1][MAX_N + 1];
	
	public static boolean isSame(int row, int col, int size) {
		int first = arr2d[row][col];
		
		for (int i = row; i < row + size; i++)
			for (int j = col; j < col + size; j++) {
				if(arr2d[i][j] != first)
					return false;
			}
		
		return true;
	}
	
	public static void divide(int row, int col, int size) {
		// row, col - 시작원소
		// 기저조건 
		if (isSame(row,col,size)) {
			if (arr2d[row][col] == -1)
				minusOne++;
			
			if (arr2d[row][col] == 0)
				zero++;
			
			if (arr2d[row][col] == 1)
				one++;
			return;
		}
		
		// 실행조건
		int newSize = size / 3;
		
		divide(row, col, newSize);
		divide(row, col + newSize, newSize);
		divide(row, col + newSize * 2, newSize);
		
		divide(row + newSize, col, newSize);
		divide(row + newSize, col + newSize, newSize);
		divide(row + newSize, col + newSize * 2, newSize);
		
		divide(row + newSize * 2, col, newSize);
		divide(row + newSize * 2, col + newSize, newSize);
		divide(row + newSize * 2, col + newSize * 2, newSize);
		
		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) 
				arr2d[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		divide(0,0,n);

		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(one);
		
		
	}
}
