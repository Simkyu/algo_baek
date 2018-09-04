package algo_baek;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 성공 - git에 올려야함
public class pb10769 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = BR.readLine();
		int happy = 0, sad = 0; 
		String result = "";
		
		for(int i = 0; i<s.length()-2 ; i++) {
			if(s.charAt(i) == ':' && s.charAt(i+1) == '-') {
				switch (s.charAt(i+2)) {
					case ')':
						happy++;
						i+=2;
						break;
					case '(':
						 sad++;
						 i+=2;
						 break;
					default :
						i+=2;
						break;
					}
				}
		}
		
		if(happy == 0 && sad == 0) {
			result = "none";
		} else if (happy > sad) {
			result = "happy";
		} else if (happy < sad) {
			result = "sad";
		} else {
			result = "unsure";
		}
		
		BW.write(result);
		BW.flush();
		BW.close();
		BR.close();
	}
}
