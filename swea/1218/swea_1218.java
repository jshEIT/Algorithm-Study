package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class swea_1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			char[] arr = new char[n];
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < str.length(); i++)
				arr[i] = str.charAt(i);
			
			int isValid = 1;
			
			for (int i = 0; i < str.length(); i++) {
				if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(' || arr[i] == '<')
					stack.push(arr[i]);
				
				if (arr[i] == '}') {
					if (stack.pop() != '{') {
						isValid = 0;
						break;
					}
				}
				
				if (arr[i] == ']') {
					if (stack.pop() != '[') {
						isValid = 0;
						break;
					}
				}
				
				if (arr[i] == ')') {
					if (stack.pop() != '(') {
						isValid = 0;
						break;
					}
				}
				
				if (arr[i] == '>') {
					if (stack.pop() != '<') {
						isValid = 0;
						break;
					}
				}
				
				
			}
			if (!stack.isEmpty())
				isValid = 0;
			
			
			
			
			System.out.println("#" + tc + " " + isValid);
			
			
			
			
		}
		
		
		
		
		
	}
}
