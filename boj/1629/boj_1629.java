package day0831;

import java.io.*;
import java.util.*;

public class boj_1629 {
	
	static long A,B,C;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		
		System.out.println(divide(A,C,B));
		
		
	}
	
	static long divide(long number, long div, long r) {
		if (r == 1) {
			return number % div;
		}
		
		long temp = divide(number,div,r/2);
		
		if (r % 2 == 0) {
			return (temp * temp) % div;
		}
		else {
			return (temp * temp  % div) * A % div;
		}
		
	}
	
	
}
