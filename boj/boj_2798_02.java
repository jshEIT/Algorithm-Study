package day0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2798_02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int currSum;
		int sum = 0;
		int gap = 299997;
		
		int [] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int z = j + 1; z < n; z++) {
					currSum = arr[i] + arr[j] + arr[z];
					if (currSum <= m && (m - currSum < gap))
						gap = m - currSum;
//						sum = currSum;
				}
			}
		}
		System.out.println(m - gap);
//		System.out.println(sum);


	}

}