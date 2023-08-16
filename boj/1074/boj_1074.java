package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N);
		
		
//		arr2d = new int[size][size];
//		divide(0,0,size);  // 배열을 만들어서 풀면 메모리 초과
//		System.out.println(arr2d[r][c]);
		
		divide(r,c,size);
		System.out.println(count);
		
		
	}
	
//	public static final int MAX_SIZE = (int)Math.pow(2, 15); // java 힙 메모리 초과
//	public static int[][] arr2d; // 배열쓰면 메모리 초과
	public static int count = 0;
	
//	public static void divide(int row, int col, int size) {
//		if (size == 2) {
//			for (int i = row; i < row + size; i++)
//				for (int j = col; j < col + size; j++)
//					arr2d[i][j] = count++;
//			
//			return;
//		}
//		
//		int newSize = size / 2;
//		
//		divide(row, col, newSize);
//		divide(row, col + newSize, newSize);
//		divide(row + newSize, col, newSize);
//		divide(row + newSize, col + newSize, newSize);
//		
//	}
	
	// 내가 간과한 것들
	// 1. 재귀가 진행될 경우, 아무리 여러 개로 나누어도 1번째 재귀가 끝나기 전에 2번째 재귀는 시작되지 않는다. -> 너무 당연한건데 매번 간과한다.
	// 2. 이 문제를 풀 경우, 1을 순차적으로 더한다는 느낌보다 size를 나눈 것들을 더해준다는 느낌
	// 3. 1780, 2630과 달리 이 문제는 전체 -> 부분으로 접근한다.
	public static void divide(int row, int col, int size) {
		
		if (size == 1)
			return;
		
		// 모두 탐색하는 것이 아니라 조건에 맞는 경우에만 탐색
		if (row < size / 2 && col < size / 2) // 좌상
			divide(row, col, size / 2);
		else if (row < size / 2 && col >= size / 2) { // 우상
			count += size * size / 4;
			divide(row, col - size / 2, size / 2);
		}
		else if (row >= size / 2 && col < size / 2) { // 좌하
			count += (size * size / 4) * 2;
			divide(row - size/2, col, size / 2);
		}
		else {
			count += (size * size / 4) * 3; // 우하
			divide(row - size/2, col - size/2, size / 2);
		}
		
		
	}
}
