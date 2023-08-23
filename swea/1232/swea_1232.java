package day0823;

import java.io.*;
import java.util.*;

// 문제 옆에 있는 테스트케이스 2개만 믿고 노드 없이 풀려다가는 오답 세례를 받게된다.
// 이번 문제는 노드가 필요하다
class Node{
	String value; 
	int left = 0;
	int right = 0;
	
	public Node(String value) {
		this.value = value;
	}
}

public class swea_1232 {
	static int n;
	static Node[] arr; // arr : 순서대로 입력받은 노드들이 들어갈 배열
	static List<Node> list; // 후위순회를 거친 노드들이 들어갈 리스트
	static Stack<String> stack; // 계산에 필요한  stack
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			arr = new Node[n + 1];
			
			for (int i = 1; i < n+1; i++) {
				// 입력은 크게 2가지로 나누어진다 - 자식이 있는 노드 vs 자식이 없는 노드
				String[] str = br.readLine().split(" "); // space를 기준으로 쪼개어 String배열을 만들어준다.
				if (str.length > 2) { // 자식이 있는 노드 - 배열 길이가 4개
					int idx = Integer.parseInt(str[0]); // node의 index
					Node node = new Node(str[1]);  // node 본체
					node.left = Integer.parseInt(str[2]); // node의 왼쪽 자식
					node.right = Integer.parseInt(str[3]); // node의 오른쪽 자식
					arr[idx] = node; 
				}
				else { // 자식이 없는 노드 - 배열의 길이가 2개 
					int idx = Integer.parseInt(str[0]);// node의 index
					Node node = new Node(str[1]);// node 본체
					arr[idx] = node;
				}
			}
			
			
			list = new ArrayList<>();
			
			postOrder(arr[1]); // 루트 노드에서부터 후위탐색 시작
			
//			System.out.println(list); // 리스트에 노드들이 잘 담겨는지 확인해보자
			
			int ans = 0; // 정답값을 넣은 변수 - 없어도 되긴 하다.
			stack = new Stack<>();
						
			for (Node e : list) {
				if (isOperand(e.value)) { // node가 연산자인 경우
					int b = Integer.parseInt(stack.pop()); // 앞선 노드 2개를 꺼낸 후
					int a = Integer.parseInt(stack.pop());
					int outcome =  calc(a,b,e.value); // 연산 진행
					ans = outcome; 
					stack.push(outcome + "");
					
				}
				else // 연산자가 아니라면(즉, 숫자라면)
					stack.push(e.value); // stack에 push
//				System.out.println(stack);
			}
			
			System.out.println("#" + tc + " " + ans);
				
		}
		
	}
	
	static void postOrder(Node node) { // 후위 순회를 위한 함수
		if (node.left != 0)  // node의 왼쪽 자식이 있는 경우
			postOrder(arr[node.left]); // 왼쪽자식에서 후위 순회
		if (node.right != 0) // node의 오른쪽 자식이 없는 경우
			postOrder(arr[node.right]); // 오른쪽 자식 후위 순회
		list.add(node); // 현재 노드는 list에 저장
	}
	
	static boolean isOperand(String c) { // 연산자인지 피연산지인지 판별하기 위한 함수
		return (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"));
	}
	
	static int calc(int a, int b, String o) { // 계산기
		if (o.equals("+"))
			return a + b;
		else if (o.equals("-"))
			return a - b;
		else if (o.equals("*"))
			return a * b;
		else
			return a / b;
	}
	
	
}
