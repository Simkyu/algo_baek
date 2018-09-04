package algo_baek;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;


// 성공 - 이진탐색으로 풀어보기
public class pb10815 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(BR.readLine());
		String[] card = BR.readLine().split(" ");
		
		int M = Integer.parseInt(BR.readLine());
		String[] card2 = BR.readLine().split(" ");
		
		
		TreeSet ts = new TreeSet();
		
		for(int i = 0 ; i<card.length; ++i) {
			ts.add(card[i]);
		}
		
		for(int j = 0 ; j<card2.length; ++j) {
			if(ts.contains(card2[j])) {
				BW.write("1 ");
			} else {
				BW.write("0 ");
			}
			
		}
		
		BW.flush();
		
		
	}
}
