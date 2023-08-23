package day0823;

import java.util.*;
import java.io.*;

public class swea_1231 {
	
	static int n;
	static char[] arr;
	
	static void inOrder(int i) {
		if (i < n + 1) {
			inOrder(i * 2);
//			if (arr[i] != '\u0000')
			System.out.print(arr[i]);
			inOrder(i * 2 + 1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			arr = new char[n + 1];
			arr[0] = '\u0000';
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				char e = st.nextToken().charAt(0);
				arr[idx] = e;
			}
			
			System.out.print("#" + tc + " ");
			inOrder(1);
			System.out.println();
			
		}
		
		
		
		
		
		
		
	}
}
