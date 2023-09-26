package day0926;

import java.io.*;
import java.util.*;

public class boj_14502 {
	static class Coord{
		int r,c;
		public Coord(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	// 처음에 ArrayIndexOutofRangeException이 계속 뜸 --> N x M 좌표임을 망각했기 때문
	static int N,M; // 행,열 길이
	static int[][] map; // 입력 좌표를 담을 배열
	static boolean[][] isNotSafe; // 복사할 생각하지 말고 방문 배열을 만들어서 체크하는 것이 효율적일듯
	static ArrayList<Coord> coords; // 좌표의 모든 경우의 수를 담을 리스트
	static Queue<Coord>queue; // 
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 리스트 초기화
		coords = new ArrayList<>();
		
		// 나올 수 있는 모든 좌표의 경우의 수를 coords리스트에 넣는다.
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				coords.add(new Coord(i,j));
		
		int cSize = coords.size(); // coords 리스트 크기를 초기화 
		int ans = 0; // 
		
		// nC3 조합을 반복문으로 구현
		for (int i = 0; i < cSize - 2; i++)
			for (int j = i + 1; j < cSize - 1; j++)
				for (int k = j + 1; k < cSize; k++) {
					Coord c1 = coords.get(i);
					Coord c2 = coords.get(j);
					Coord c3 = coords.get(k);
					
					// c1,c2,c3 좌표가 모두 0인 경우에만 벽을 세울 수 있다.
					if (map[c1.r][c1.c] == 0 && map[c2.r][c2.c] == 0 && map[c3.r][c3.c] == 0) {		
						map[c1.r][c1.c] = 1;
						map[c2.r][c2.c] = 1;
						map[c3.r][c3.c] = 1;
						
						
						int temp = findSafe(); // findSafe메서드를 통해 안전 지역을 구하고
						ans = Math.max(ans,temp); // 기존 ans와 temp 중 큰 값을 갱신
						
						// 다시 원래대로 되돌리기
						map[c1.r][c1.c] = 0;
						map[c2.r][c2.c] = 0;
						map[c3.r][c3.c] = 0;
					}
						
					
				}
		
		System.out.println(ans);
	
		
	}
	
	// 범위를 벗어나는지 체크하는 메서드
	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
	
	// 벽 찾기 
	static void dfs(int wallNum) {
		if(wallNum == 3) {
			findSafe();
			return;
		}
		
		for (int i = 0 ; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wallNum + 1);
					map[i][j] = 0;
				}
			}			
		}
	}
	
	
	// 안전지역을 찾는 메서드
	static int findSafe() {
		queue = new LinkedList<>(); // 좌표를 담을 큐를 초기화
		isNotSafe = new boolean[N][M]; // 안전지역의 수를 찾기 위해 배열 초기화
		
		for (int i = 0 ; i < N; i++) {
			for (int j = 0 ; j < M; j++) {
				if(map[i][j] == 1) // map의 좌표값이 1이면(벽이면)
					isNotSafe[i][j] = true; // true처리 -> 벽은 안전지역으로 처리되지 않기 때문에 안전지역 개수를 세는 경우 바이러스와 다를바 없다.
				else if(map[i][j] == 2) { // map의 좌표값이 2이면(바이러스라면)
					isNotSafe[i][j] = true; // true처리 해주고
					queue.offer(new Coord(i,j)); //queue에 넣어준다.
				}
			}
		}
		
		int total = 0; 
		while(!queue.isEmpty()) {
			Coord curr = queue.poll();
			int currR = curr.r;
			int currC = curr.c;
			
			for (int d = 0; d < 4; d++) { // 4방 탐색을 진행하면서
				int nr = currR + dr[d];
				int nc = currC + dc[d];
				// 범위 밖이거나, 벽 또는 바이러스가 차지한 경우 -> 바이러스가 퍼질 수 없다.
				if(!inRange(nr,nc) || isNotSafe[nr][nc])
					continue;
				isNotSafe[nr][nc] = true; // 바이러스가 갈 수 있는 곳이라면 바이러스 방문처리를 해주고
				queue.offer(new Coord(nr,nc)); // 큐에 넣는다.
			}
		}
		
		// 안전 지역의 개수를 센다.
		for (int i = 0 ; i < N;i++)
			for (int j = 0; j < M; j++)
				if(!isNotSafe[i][j]) // 안전하지 않지 않은 지역 -> 안전한 지역
					total++;
		
		
		return total;
	}
	
}
