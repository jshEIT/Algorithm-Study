package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.math.BigInteger;

public class boj_2407 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger res = BigInteger.valueOf(1);
		for (int i = n; i > n - m; i--) {
			res = res.multiply(BigInteger.valueOf(i));
		}
		
		for (int i = 1; i <= m; i++) {
			res = res.divide(BigInteger.valueOf(i));
		}
		
		System.out.println(res);
	} 
	/*
	 BigInteger 라이브러리 사용
	 초기화 : BigInteger 변수명 = BigInteger.valueOf(쓰고 싶은 숫자);
	 연산의 상대 또한 BigInteger 타입이어야한다.
	 int와 long으로도 감당하기 힘들 때 쓴다
	 
	 곱하기 
	 변수명.multiply(BigInteger.valueOf(숫자));
	 
	 나누기
	 변수명.divide(BigInteger.valueOf(숫자));
	 
	 더하기 : add  빼기 : substract  나누기 : remainder;
	 
	 형변환
	 intValue(), longValue(), floatValue(), doubleValue(), toString()
	
	 비교
	 compareTo() : 맞으면 0, 틀리면 -1
	*/
	

	

}
