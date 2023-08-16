package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;

public class boj_1992 {
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr2d[i][j] = str.charAt(j) - '0';
			}
		}
		
		divide(0,0,N);

	}
	
	public static final int MAX_N = 64;
	public static int[][] arr2d = new int[MAX_N][MAX_N];
	
	public static void divide(int r, int c, int size) {
		// 기저조건
		if (isSame(r, c, size)) {
			if(arr2d[r][c] == 1) 
				System.out.print("1");
			else
				System.out.print("0");
			
			return;
		}
		
		int newSize = size / 2;
		
		// 실행조건
		System.out.print("(");
		divide(r, c, newSize);
		divide(r, c + newSize, newSize);
		divide(r + newSize, c, newSize);
		divide(r + newSize, c + newSize, newSize);
		System.out.print(")");
		
	}
	
	public static boolean isSame(int r, int c, int size) {
		int std = arr2d[r][c];
		
		for (int i = r; i < r + size; i++) 
			for (int j = c; j < c + size; j++) {
				if (arr2d[i][j] != std) 
					return false;
			}
		
		return true;
		
	}
	
	
	
}
