package day0718;

import java.util.Scanner;

public class swea_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트케이스
		
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); //  n x n
			String temp [][] = new String[n][n]; // 입력 String을 받을 배열 필요
			int arr2d[][] = new int[n][n]; // 배열 크기 선언
			int sumVal = 0; // 총합 넣을 것 초기화
			int idx = n / 2; // 중심축; ex) n = 7이면 idx = 3

			
			// 배열 집어넣기
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < n; j++) {
					arr2d[i][j] = str.charAt(j) - '0';
				}
			}
			
			
			// 가로 			
			for (int i = 0; i < idx + 1; i++) {
				for (int j = idx - i; j < n - (idx - i); j++) {
					sumVal += arr2d[i][j];
//				System.out.println(sumVal);
				}
			}
			
			// 세로
			for (int i = idx + 1; i < n; i++) {
				for (int j = i - idx; j < n - (i - idx); j++) {
					sumVal += arr2d[i][j];
//				System.out.println(sumVal);
				}
			}
			
			System.out.printf("#%d %d", tc, sumVal);
			System.out.println();
//			
		}

	}

}
