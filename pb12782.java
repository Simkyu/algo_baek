package algo_baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.*;

// 백준사이트 런타임 에러 (동작은 제대로 하는듯 보임)
public class pb12782 {

	public static void main (String args[]) throws  IOException {
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));

		
		// 횟수
		int time = Integer.parseInt(BR.readLine());
		String result ="";
		String t;
		String[] s;
		int and, M1, N1;
		
		
		for(int i = 0; i <time ; ++i) {
		 	t = BR.readLine();
		 	s = t.split(" ");

		 	int M = Integer.parseInt(s[0],2);
		 	int N = Integer.parseInt(s[1],2);
		 	
		 	// 1101 1001 : 1-0 : 1
		 	// 110001 101101 : 1-2 : 2
		 	// 11001 11111 : 0-2 : 2 
		 	
		 	// 10000 01111
		 	
		 	M1 = Integer.bitCount(M);
		 	N1 = Integer.bitCount(N);
		 	
		 	String temp = Integer.toBinaryString(M & N);
		 			
		 	and = Integer.bitCount(Integer.parseInt(temp,2));
		 	
		 	if(and == temp.length()) {
		 		BW.write(0);
		 		BW.newLine();
		 	} else {
		 		BW.write(Integer.toString(Math.max(M1-and, N1-and)));
		 		BW.newLine();
		 	}
		}

			BW.flush();
			BW.close();
			BR.close();
		
		
	}
	
}
