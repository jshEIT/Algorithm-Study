package day0816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 출처 - https://lasbe.tistory.com/134

public class boj_2447_better_solution {
	
	static String[][] arr = null; // null로 초기화해도 된다.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(br.readLine()); // 크기 
		arr = new String[size][size];
		
		star(0, 0, size);
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// null 상태로 있는 빈공간을 채워주기
				bw.write(arr[i][j] != null? arr[i][j] : " ");
			}
			bw.write("\n");
		}
		bw.flush();
		
	}
	
	public static void star(int x, int y, int size) {
		// 최소단위 1 로 분할했으면 별 저장
		if (size == 1) {
			arr[x][y] = "*";
			return;
		}
		
		// size가 1이 될 때까지 3x3 크기로 계속해서 분할
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// 가운데 공간이면 건너뛰기
				if (!(i == 1 && j == 1))
					star(x + i*size/3, y + j*size/3, size/3); // newSize를 쓸거면 행과 열을 각각 i * size, j * size 적용
			}
		}
		
	}
}
