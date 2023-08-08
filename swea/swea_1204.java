package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1
1
10 8 7 2 2 4 8 8 8 9 5 5 3
 * */


public class swea_1204 {
	public static final int MAX_N = 1000;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			int[] students = new int[MAX_N];
			int[] counts = new int[101];
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			
			// 학생 점수 입력받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0 ; i < 1000; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}
			
			// 점수의 빈도수 입력
			for (int i = 0 ; i < 1000; i++) {
				counts[students[i]]++;
			}
			
			
			int max = 0;
			for (int i = 100; i  > 0; i--) {
				if (counts[max] < counts[i])
					max = i;
			}
			
//			System.out.println(Arrays.toString(counts));
			System.out.println("#" + tc + " " + max);
			
		}
		
	}
	
}