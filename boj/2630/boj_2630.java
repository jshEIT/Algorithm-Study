package day0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2630 {
	public static final int MAX_N = 128;
	public static int[][] arr2d = new int[MAX_N][MAX_N];
	public static int one = 0;
	public static int zero = 0;
	
	// 주어진 사각형 안에 원소들이 같은지 판별
	public static boolean checkSame(int sr, int sc, int er, int ec) {
		boolean isSame = true;
		
		int first = arr2d[sr][sc];
		
		outer : for (int r = sr; r < er; r++) {
			for (int c = sc; c < ec ; c++) {
				if (arr2d[r][c] != first) {
					isSame = false;
					break outer;
				}	
			}
		}
		return isSame;			
	}
	// 이렇게 짜기 보다는 그냥 size를 이용했으면 매개변수를 줄일 수 있었을듯...
	public static void divide(int sr, int sc, int er, int ec) {
		// 기저 조건 - 다 돌았는데 값이 똑같을 때 
		if (checkSame(sr, sc, er, ec)) {
			if (arr2d[sr][sc] == 1) // 1이면 one++
				one++;
			else // 0이면  zero++
				zero++;
			
			return;
		}
		
		// 실행 부분
		else { // 4개의 사분면으로 나눈다.
			divide(sr,sc,(er+sr)/2,(sc+ec)/2);
			divide(sr,(sc+ec)/2,(sr+er)/2,ec);
			divide((sr+er)/2,sc,er,(sc+ec)/2);
			divide((sr+er)/2,(sc+ec)/2,er,ec);
		}		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr2d[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,n,n);
		
		System.out.println(zero);
		System.out.println(one);
		
		
		
	}
}
