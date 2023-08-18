package day0818;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_4779 {

	public static char[]arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		while((str = br.readLine()) != null) {
			int n = Integer.parseInt(str);
			
			int size = (int)Math.pow(3, n);
			
			arr = new char[size];
			
			for (int i = 0; i < size; i++)
				arr[i] = '-';
			
			cantoring(0,size);
			
			for (int i = 0; i < size; i++)
				bw.write(arr[i]);
			bw.write("\n");
			bw.flush();
		}
		
		
	}
	
	
	static void cantoring(int s, int size) {
		if (size == 1) {
			return;
		}
			
		int newSize = size / 3;
		
		for (int i = s + newSize; i < s + newSize * 2;i++)
			arr[i] = ' ';
		
		cantoring(s,newSize);
		cantoring(s + newSize * 2, newSize);
		
		
	}
	
	
}
