package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class boj_10799 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = new char[str.length()];
		
		for (int i = 0; i < str.length(); i++)
			arr[i] = str.charAt(i);
		
		Stack<Character> stack = new Stack<>();
		
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (arr[i] == '(') {
				stack.push(arr[i]);
			}
			else if (i != 0 && arr[i-1] == '(' && arr[i] == ')') {
				stack.pop();
				count += stack.size();
			}
			else if (arr[i] == ')') {
				stack.pop();
				count++;
			}
				
		}
		
		System.out.println(count);
		
	}
}
