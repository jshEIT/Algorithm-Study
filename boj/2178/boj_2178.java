package day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;


	
public class boj_2178 {
	
	static final int MAX_N = 100;
	static int N,M;
	static int[][] maze = new int[MAX_N][MAX_N];
	static int[][] visited = new int[MAX_N][MAX_N];
	
	static int[] dr = new int[] {0,1,0,-1};
	static int[] dc = new int[] {1,0,-1,0};
	
	static Queue<Pair> q = new LinkedList<>(); // Pair형 Queue선언
	

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		visited[0][0] = 1;
		int ans = BFS(0,0);
		System.out.println(ans);	
	}
	
	// 미로의 범위를 벗어나지 않는지 검사
	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
	
	// 갈 수 있는 곳인지 검사
	static boolean canGo(int r, int c) {
		//     범위 안에 있으면서	       갈 수 있는 곳이어야 하고	    아직 방문하지 않은 곳이어야 한다.
		return inRange(r,c) && maze[r][c] == 1 && visited[r][c] == 0;
	}
	
	static int BFS(int r, int c) {
		// 입력을 Pair형으로 큐에 삽입
		q.offer(new Pair(r,c));
		
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int r1 = p.getR();
			int c1 = p.getC();
			
			// 4방탐색 시작
			for (int i = 0; i < 4; i++) {
				int nr = r1 + dr[i];
				int nc = c1 + dc[i];
				if (canGo(nr,nc)) { // 갈 수 있는 곳이라면
					visited[nr][nc] = 1; // 방문처리
					maze[nr][nc] = maze[r1][c1] + 1; // 현재 값에 1을 더해줌
					q.offer(new Pair(nr,nc)); // 큐에 삽입
				}
			}
		}
		return maze[N-1][M-1];
	}
	
}

//파이썬에서의 튜플을 비슷하게 구현
class Pair {
	private int r;
	private int c;
	
	public Pair(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public int getR() {
		return this.r;
	}
	
	public int getC() {
		return this.c;
	}
}
