package day0720;

import java.util.Scanner;

public class swea_1961 {	
	public static int[][] rotation(int[][] arr) {
		int[][] newArr = new int[arr.length][arr.length];
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length; c++) {
				newArr[r][c] = arr[arr.length-c-1][r];
			}
		}
		return newArr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			// N x N 배열을 위한 N 입력
			int N = sc.nextInt();
			// 2차원 배열
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt(); // 문자열로 입력
				}
			}
			
			// 회전한배열 3개
			int[][] arr_90 = rotation(arr);
			int[][] arr_180 = rotation(arr_90);
			int[][] arr_270 = rotation(arr_180);
			
			System.out.printf("# %d", tc);
			System.out.println();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr_90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr_180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr_270[i][j]);
				}
				System.out.println();
			}
		}
	}	

}
