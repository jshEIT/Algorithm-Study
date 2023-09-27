package day0927;

import java.io.*;
import java.util.*;

public class boj_2096 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int dpMax[][] = new int[N + 1][3];
		int dpMin[][] = new int[N + 1][3];
		int down[][] = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				down[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + down[i][0];
			dpMax[i][1] = Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]),dpMax[i-1][2]) + down[i][1];
			dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + down[i][2];
			
			dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + down[i][0];
			dpMin[i][1] = Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]),dpMin[i-1][2]) + down[i][1];
			dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + down[i][2];
		}
		
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dpMax[N][i]);
			min = Math.min(min, dpMin[N][i]);
//			System.out.println(dpMax[N][i] + " " + dpMin[N][i]);
		}
		
		System.out.println(max + " " + min);
		
	}
}
