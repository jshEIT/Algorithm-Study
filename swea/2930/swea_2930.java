package day0824;

import java.io.*;
import java.util.*;

public class swea_2930 {
	public static int[] heap;
	public static int heapSize;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			heap = new int[n + 1];
			heapSize = 0;
			
			System.out.print("#" + tc + " ");
			
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				if (str[0].equals("1"))
					insert(Integer.parseInt(str[1]));
				else
					remove();
			}
			System.out.println();
		}
		
		
	}
	
	public static void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	
	public static void heapify(int i) { // 최대 힙 만들어주기
		int largest = i; // 현재노드
		int left = i * 2; // 왼쪽 자식
		int right = i * 2 + 1; // 오른쪽 자식
		
		if (left < heap.length && heap[left] > heap[largest]) 
			largest = left;
		if (right < heap.length && heap[right] > heap[largest])
			largest = right;
		
		if (largest != i) {
			swap(i,largest);
			heapify(largest);
		}
	}
	
	public static void insert(int x) {
		heap[++heapSize] = x; // 최 종단에 원소 삽입
		
		int ch = heapSize; // 자식, 현재 노드
		int par = ch / 2; // 부모
		
		while(par > 0 && heap[ch] > heap[par]) {
			swap(par,ch); // 부모-자식 바꿔주고
			// 한 단계 씩 올려주기
			ch = par; 
			par = ch/2;
		}
	}
	
	public static void remove() {
		if (heapSize == 0) {
			System.out.print(-1 + " ");
			return;
		}
			
		System.out.print(heap[1] + " ");
		heap[1] = heap[heapSize];
		heapSize--;
		heapify(1);
	}
}
