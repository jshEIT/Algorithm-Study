package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class swea_8931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				
				if (!stack.isEmpty() && num == 0) 
					stack.pop();
				else
					stack.push(num);
				
			}
			
			int sum = 0;
			
			while (!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			System.out.println("#" + tc + " " + sum);
			
		}
		
		
		
	}
}
