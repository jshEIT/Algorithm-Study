package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2999 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int n = str.length();
		int r = 0,c = 0; // r : 행 c : 열
	
		
		// r,c값 구하기
		for (int i = 1; i <= n; i++) {
			if ((n % i == 0) && (i <= n / i)) {
				r = i;
				c = n / i;
			}
		}
//		System.out.println(r + " " + c);
		
		// 출력을 위한 2차원 배열
		int count = 0;
		char[][] arr2d = new char[c][r];
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				arr2d[i][j] = str.charAt(count++);
//				System.out.print(arr2d[j][i]);
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr2d[j][i]);
			}
		}
	}

}
