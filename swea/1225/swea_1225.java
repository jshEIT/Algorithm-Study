package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

public class swea_1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			String useless = br.readLine();
			
			st = new StringTokenizer(br.readLine());
			
			Queue<Integer> queue = new LinkedList<>();
			
			// queue에 넣기
			for (int i = 0; i < 8;i++)
				queue.offer(Integer.parseInt(st.nextToken()));
			
			total : while (true) {
				for (int c = 1; c <= 5; c++) {
					int temp = queue.poll();

					if (temp - c <= 0) {
						queue.offer(0);
						break total;
					}
					queue.offer(temp - c);
				}
				
			}
			System.out.print("#" + tc + " ");
			
			while(!queue.isEmpty())
				System.out.print(queue.poll() + " ");
			
			System.out.println();
			
			
		}
		
		
		
		
	}
}
