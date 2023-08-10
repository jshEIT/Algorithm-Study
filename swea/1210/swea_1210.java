package day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1210 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			
			int[][] ladder = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			// 목표지점에서 반대로 올라가기
			// 목표지점 찾기
			int dest = 0;
			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2)
					dest = i;
			}
			
			// 목표지점에서 출발
			int r = 99;
			int c = dest;
			
			while(true) {
				if (c < 99 && ladder[r][c+1] == 1) {
					c++;
					ladder[r][c] = 0; //  방문처리
				}
					
				else if (c > 0 && ladder[r][c-1] == 1) {
					c--;
					ladder[r][c] = 0; 
				}

				else if (ladder[r-1][c] == 1) {
					r--;
					ladder[r][c] = 0; 
				}

				if (r == 0)
					break;
				
//				System.out.println(r + " " +  c);
			}
			
			
			System.out.println("#" + t + " " + c);
			
		}
		
	}

}
