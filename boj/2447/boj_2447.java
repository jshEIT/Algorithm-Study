package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class boj_2447 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = " ";
			}
		}
		
		printStar(0,0,N);
		
//		// System.out.print를 쓰면 시간초과가 뜬다.
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		// 따라서 BufferedWriter를 쓰도록 하자 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
		
	}
	
	
	
	public static final int MAX_N = (int)Math.pow(3, 8);
	static String[][] arr = new String[MAX_N][MAX_N];
	
	static void printStar(int r, int c, int size) {
		// 기저조건
		if (size == 3) {
			for (int i = r; i < r + size; i++) {
				for (int j = c; j < c + size; j++) {
					if (i == (r + r + size) / 2 && j == (c + c + size) / 2) {
						arr[i][j] = " ";
						continue;
					}
					arr[i][j] = "*";
				}
			}
			return;
		}
		
		
		// 실행 조건
		int newSize = size / 3;
		
		printStar(r,c,newSize);
		printStar(r,c + newSize,newSize);
		printStar(r,c + newSize * 2,newSize);
		
		printStar(r + newSize,c,newSize);
//		printStar(r + newSize,c + newSize,newSize); // 가운데 비우기
		printStar(r + newSize,c + newSize * 2,newSize);
		
		printStar(r + newSize * 2,c,newSize);
		printStar(r + newSize * 2,c + newSize,newSize);
		printStar(r + newSize * 2,c + newSize * 2,newSize);

		
		
	}
	
	
	
	
	
}
