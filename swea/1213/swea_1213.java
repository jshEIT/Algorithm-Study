package day0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			// 테스트 케이스
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			// 찾고 싶은 문자
			String find = br.readLine();
			char[] findArr = find.toCharArray();
			
			// 전체 문자
			String total = br.readLine();
			char[] totalArr = total.toCharArray();
			
			// 찾고 싶은 문자의 개수
			int count = 0;
			
			
			for (int i = 0; i < totalArr.length - findArr.length + 1; i++) {
				if (findArr[0] == totalArr[i]) {
					boolean isChar = true;
					inner : for (int j = 0; j < findArr.length; j++) {
						if (findArr[j] != totalArr[i + j]) {
							isChar = false;
							break inner;
						}
						

					}
					if (isChar)
						count++;
					
				}
				
				
			}
			
			System.out.println("#" + tc + " " + count);
			
			
			
			
			
			
			
		}
		
		
		
		
		
	}
}
