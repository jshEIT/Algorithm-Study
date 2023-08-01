package day0726;

import java.util.Scanner;

public class swea_1954 {
    public static final int MAX_NUM = 100;
    public static final int DIR_NUM = 4;

    public static int n;
    public static int[][] arr = new int[MAX_NUM][MAX_NUM];

    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};

    public static int currX = 0, currY = 0;
    public static int dir = 0;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
//        m = sc.nextInt();

        arr[currX][currY] = 1;

        for (int i = 2; i <= n * n;i++) {
            // 현재 배열에서 이동시킨 값 계산
            int nextX = currX + dx[dir];
            int nextY = currY + dy[dir];

            // 이동시킨 값이 범위를 넘는다면 방향을 바꾼다/
            if (!(inRange(nextX,nextY)) || arr[nextX][nextY] != 0) 
                dir = (dir + 1) % 4;

            // 그 다음 위치로 이동한 후 다음 배열에 값 채워 넣기
            currX = currX + dx[dir];
            currY = currY + dy[dir];
            arr[currX][currY] = i;
            
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
		
	}
}

