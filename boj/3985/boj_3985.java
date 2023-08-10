package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3985 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int estimate = 0;
		int estimateNum = 1;
		
		int real[] = new int[1001];
		int idx[] = new int[1001];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int temp = end - start + 1; // 현재 방청객의 예상 케이크 크기
						
			// 많이 받을 것으로 예상되는 방청객 번호 갱신
			if (temp > estimate) {
				estimate = temp;
				estimateNum = i + 1;
			}
				
			// 실제 받을 것으로 예상되는 케이크 크기 
			for (int k = start; k <=end; k++) {
				if (real[k] != 0)
					continue;
				else
					real[k] = i + 1;
			}
		}
		
		for (int i = 1; i <= L; i++) {
			idx[real[i]] += 1;
		}
		
		int max = 0;
		int realNum = 0;
		for (int i = 1; i <=N; i++) {
			if (idx[i] > max ) {
				max = idx[i];
				realNum = i;
			}
		}

		System.out.println(estimateNum);
		System.out.println(realNum);

	}

}
