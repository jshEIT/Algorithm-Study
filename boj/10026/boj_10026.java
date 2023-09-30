package boj;

import java.io.*;
import java.util.*;

public class boj_10026 {
	static int N,originNum, rgBlindNum;
	static char[][] origin;
	static char[][] rgBlind;
	static boolean[][] visited;
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		origin = new char[N][N];
		rgBlind = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				origin[i][j] = temp[j];
				rgBlind[i][j] = temp[j];
				if (temp[j] == 'G')
					rgBlind[i][j] = 'R';
			}
		}
		
		visited = new boolean[N][N];
		originNum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(dfs(i,j,origin))
					originNum++;
			}
		}
		
		visited = new boolean[N][N];
		rgBlindNum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(dfs(i,j,rgBlind))
					rgBlindNum++;
			}
		}
		
		System.out.println(originNum + " " + rgBlindNum);
		
	}
	
	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
	
	static boolean dfs(int r, int c,char[][]map) {
		if(visited[r][c])
			return false;
		
		
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (!inRange(nr,nc) || map[nr][nc] != map[r][c])
				continue;
			
			dfs(nr,nc,map);
		}
		
		return true;
		
	}
	
}
