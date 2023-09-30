package boj;

import java.io.*;
import java.util.*;

public class boj_9019 {
	
	// 숫자와 해당 숫자에 도달하기까지 필요한 연산들을 저장하기 위한 클래스
	static class Number{
		int num;
		String str;
		public Number(int num, String str) {
			this.num = num;
			this.str = str;
		}
	}
	
	static int A,B;
	static Queue<Number> queue;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken()); // 시작 숫자
			B = Integer.parseInt(st.nextToken()); // target 숫자
			
			visited = new boolean[10000];
			
			queue = new LinkedList<>();
			queue.offer(new Number(A, ""));
			visited[A] = true;
			
			while(!queue.isEmpty()) {
				Number currNum = queue.poll();
				
				if (currNum.num == B) { // 현재 숫자가 target이라면 
					System.out.println(currNum.str);  // 현재 숫자까지 도달하기 위한 연산들을 출력하고
					break; // while문 멈춤
				}
				
				// 방문하지 않은 숫자라면 숫자와 연산을 기록해두고
				// queue에 저장하고 방문처리
				if(!visited[calD(currNum.num)]) { 
					queue.offer(new Number(calD(currNum.num),currNum.str + "D")); 
					visited[calD(currNum.num)] = true;
				}
				if(!visited[calS(currNum.num)]) {
					queue.offer(new Number(calS(currNum.num),currNum.str + "S"));
					visited[calS(currNum.num)] = true;
				}
				if(!visited[calL(currNum.num)]) {
					queue.offer(new Number(calL(currNum.num),currNum.str + "L"));
					visited[calL(currNum.num)] = true;
				}
				if(!visited[calR(currNum.num)]) {
					queue.offer(new Number(calR(currNum.num),currNum.str + "R"));
					visited[calR(currNum.num)] = true;
				}
				
			}
			
		}
		
		
		
	}
	
	// int -> String 또는 String -> int로 바꾸는 연산 필요하지 않다.
	// 0을 따로 고려하지 않아도 된다.
	// 몫과 나머지를 적절하게 활용하자
	static int calD(int num) {
		return (num * 2) % 10000; 
	}
	
	static int calS(int num) {
		return (num == 0) ? 9999:num-1;
	}
	
	static int calL(int num) { // 1234 -> 2341 
		return (num % 1000) * 10 + num/1000;
	}
	
	static int calR(int num) { // 1234 -> 4123
		return (num % 10) * 1000 + num/10;
	}
	
	
}
