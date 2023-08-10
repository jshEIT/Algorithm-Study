package day0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;

public class boj1592 {
	public static final int MAX_INT = 50;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int L = sc.nextInt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		
		int[] arr = new int[MAX_INT + 1];
		
		arr[1] = 1;
		int currIdx = 1;
		int count = 0;
		
		while (true) {
			if (arr[currIdx] == M)
				break;
			
			// 받은 횟수가 홀수 -> 시계방향
			if (arr[currIdx] % 2 == 1) {
				if (currIdx + L > N) 
					currIdx = currIdx + L - N;
				else
					currIdx += L;
			}
			else {
				if (currIdx - L < 1)
					currIdx = N + currIdx - L;
				else
					currIdx -= L;
			}
			
			arr[currIdx]++;
			count++;
		}
		System.out.println(count);
	}

}
