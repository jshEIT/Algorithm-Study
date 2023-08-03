package day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj_8958 {
	public static final int MAX_N = 80;
	public static int n;
	public static char arr[] = new char[MAX_N];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			char arr[] = str.toCharArray();
			
			int sum = 0;
			int count = 0;
			
			for (char c : arr) {
				if (c == 'O') {
					sum += 1 + (count++);
				}
				else {
					count = 0;
				}
			}
			System.out.println(sum);
		}
	}
}
