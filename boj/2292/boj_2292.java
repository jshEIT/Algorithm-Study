package day0721;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class boj2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int target = Integer.parseInt(st.nextToken());
		int count = 1;
		int start = 2;
		
		
		while (true) {
			if (target == 1) {
				count = 0;
				break;
			}
				
			if (target >= start  && target < start + 6 * count)
				break;
			start += 6*count;
			count++;
		}
		System.out.println(count + 1);
		
	}

}
