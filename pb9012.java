package algo_baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 성공
public class pb9012 {
	public static void main (String args[]) throws IOException {
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(BR.readLine());
		
		String s;
			
		for(int i = 0; i < T; i++) {
			s = BR.readLine();
			Stack st = new Stack();
			
			for(int j = 0; j< s.length(); j++) {
				if( s.charAt(j) == '(') {
					st.push("(");
				} else if( s.charAt(j) == ')') {
					if(st.isEmpty()) {
						st.push("x");
						break;
					} else {
						st.pop();
					}
				}
			}
			
			if(st.isEmpty()) {
				BW.write("YES\n");
			} else {
				BW.write("NO\n");
			}
		}
		BR.close();
		BW.flush();
		BW.close();
	}
}
