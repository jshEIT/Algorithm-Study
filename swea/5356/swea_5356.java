package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea_5356 {
	public static final int MAX_N = 15;
	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			char[][] arr2d = new char[5][MAX_N];
			
			for (int i = 0; i < 5; i++) {
				String str = br.readLine();
				for (int j = 0; j < str.length();j++)
					arr2d[i][j] = str.charAt(j);
			}
			
			List<Character> ans = new ArrayList<>();
			
			int count = 0;
			
			for (int j = 0; j < MAX_N; j++) {
				for (int i = 0; i < 5; i++) {
					if (arr2d[i][j] == '\0')
						continue;
					else {
						ans.add(arr2d[i][j]);
					}

				}
			}
			
			System.out.print("#" + tc + " ");
			
			for (char e : ans)
				System.out.print(e);
			
			System.out.println();
		}
		 
		
		
		
		 
	}
}
