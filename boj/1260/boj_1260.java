package day0818;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;


import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class boj_1260 {
	public static boolean[] visited_dfs;
	public static boolean[] visited_bfs;
	
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void dfs(int x) {
		visited_dfs[x] = true; // 방문처리
		System.out.print(x + " ");
		
		for (int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if (!visited_dfs[y]) 
				dfs(y);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited_bfs[start] = true;
		
		while (!q.isEmpty()) {
			int y = q.poll();
			System.out.print(y + " ");
			
			for (int i = 0; i < graph.get(y).size();i++) {
				int x = graph.get(y).get(i);
				if (!visited_bfs[x]) {
					q.offer(x);
					visited_bfs[x] = true;
				}
			}

		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		visited_dfs = new boolean[N + 1];
		visited_bfs = new boolean[N + 1];

		
		// 그래프 초기화
		for (int i = 0; i < N + 1; i++)
			graph.add(new ArrayList<Integer>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(k).add(v);
			graph.get(v).add(k);
			
		}
		
		for (int i = 0; i < graph.size(); i++)
			graph.get(i).sort(Comparator.naturalOrder());
		

		
		
		dfs(V);
		System.out.println();
		bfs(V);
		
		
		
	}
	
}
