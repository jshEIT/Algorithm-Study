package day0926;

import java.io.*;
import java.util.*;

public class boj_5430 {
	static int N,cntR;
	static List<String> commands;
	static Deque<String> numbers;
	static List<String> ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 0; tc < T; tc++) {
			commands = Arrays.asList(br.readLine().split(""));
			N = Integer.parseInt(br.readLine().trim());
			int cntD = commands.stream().filter(s -> s.equals("D")).map(s -> 1).reduce(0, Integer::sum);
			
			String[] str = br.readLine().split(",");
			if (N != 0) {				
				str[0] = str[0].replace("[", "");
				str[N - 1] = str[N - 1].replace("]", "");
			}
			numbers = new LinkedList<>(Arrays.asList(str));
			
			cntR = 0;
			if (cntD > N) {
				sb.append("error").append("\n");
			}
			else if (N == 0) { 
				sb.append("[]").append("\n");
			}
			else {
				for (String c : commands) {
					if (c.equals("R")) {
							++cntR;
						}
					else {
						
						if (cntR % 2 == 0)
							numbers.pollFirst();
						else
							numbers.pollLast();
						}
				}
				ans = new ArrayList(numbers);
				if (cntR % 2 == 1) {
					Collections.reverse(ans);
				}
				sb.append("[");
				for (int i = 0; i < ans.size();i++) {
					if(i == ans.size() - 1)
						sb.append(ans.get(i));
					else
						sb.append(ans.get(i)).append(",");
				}
				sb.append("]");
				sb.append("\n");
			}
			
			
		}
		
		System.out.println(sb);
		
	}
}