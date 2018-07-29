package algo_baek;
import java.util.Iterator;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.util.ListIterator;

public class pb1406 { //
	public static void main(String args[]) throws IOException {
		
		LinkedList List = new LinkedList();
			
		// 속도 향상을 위해 bufferedReader 사용.
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 String line = null;
		 
		String S = br.readLine();
		
		// int index => ListIterator 사용(속도 차이)
		ListIterator iter = List.listIterator();
		
		for(int i = 0; i<S.length(); i++) {
			iter.add(S.charAt(i));
			iter.hasNext();
		}
		
		int N = Integer.parseInt(br.readLine());
		
		String c;
	
		//0 1 2 3 4
		// a b c d
		for(int i = 0; i<N; i++) {
			
				c = br.readLine();
			switch (c.charAt(0)) {
			
			case 'P':
				iter.add(c.charAt(2));
				
				break;
		
			case 'D':
				if(iter.hasNext()) {
					iter.next();
				}
				break;
			case 'B':
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			
			case 'L':
				if(iter.hasPrevious()) {
					iter.previous();
				}
				break;
			}
		}
		
		br.close();
		
		// 속도 향상을 위해 BufferedWriter와 StringBuilder 사용.
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		
		for (Object obj : List) {
			  sb.append(obj.toString());
			}
			
		
		wr.write(sb.toString());
		wr.flush();
		wr.close();
	
		
	}

}
