package day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2653 {
	public static final int MAX_N = 100;
	public static final int MAX_R = 100;
	public static int[] x1= new int[MAX_N + 1];
	public static int[] x2 = new int[MAX_N + 1];
	public static int[] y1 = new int[MAX_N + 1];
	public static int[] y2 = new int[MAX_N + 1];
	public static int[][] painted = new int[MAX_R + 1][MAX_R + 1];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			x1[i] = x;
			x2[i] = x + 10;
			y1[i] = y;
			y2[i] = y + 10;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int x = x1[i]; x < x2[i]; x++) {
				for (int y = y1[i]; y < y2[i]; y++) {
					painted[x][y] = 1;
				}
			}
		}
		
		int count  = 0;
		for (int i = 0; i < MAX_R; i++) {
			for (int j = 0; j < MAX_R; j++) {
				if (painted[i][j] == 1)
					count++;
			}
		}
		System.out.println(count);
	}
}
