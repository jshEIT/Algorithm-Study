package day0830;

import java.io.*;
import java.util.*;

public class swea_5215 {
	static int N,L,maxScore;
	static int[] cals;
	static int[] scores;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			scores = new int[N];
			cals = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				cals[i] = Integer.parseInt(st.nextToken()); 
			}
			
			maxScore = 0;
			dfs(0,0,0);
			System.out.println("#" + tc + " " + maxScore);
			
		}
		
	}
	
	static void dfs(int score, int cal, int depth) {
		if (cal <= L) {
			if (maxScore < score)
				maxScore = score;
		}
		
		if (cal > L || depth == N)
			return;
		
		
		dfs(score,cal,depth + 1);
		dfs(score + scores[depth], cal + cals[depth],depth + 1);
		
	}
	
}
