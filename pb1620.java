package algo_baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


// 시간초과
public class pb1620 {
	static int c = 0;
	public static void main(String args[]) throws IOException {
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(BR.readLine());
		int input;
		
		TreeNode2 root = new TreeNode2(Integer.parseInt(BR.readLine()));
		BW.write(Integer.toString(c));
		BW.newLine();
		for(int i = 1 ; i < N ; ++i) {
			input = Integer.parseInt(BR.readLine());
			insert(input,root);
			BW.write(Integer.toString(c));
			BW.newLine();
			
		}
		BW.flush();
		BW.close();
		BR.close();
	}
	
	static void insert(int x , TreeNode2 tn){
		c++;
		if(x < tn.n ) {
			if(tn.left == null) {
				tn.left = new TreeNode2(x);
			} else {
				insert(x , tn.left);
			}
		} else {
			if(tn.right == null) {
				tn.right = new TreeNode2(x);
			} else {
				insert(x , tn.right);
			}
		}
	}
}

class TreeNode2 {
	int n;
	TreeNode2 left = null;
	TreeNode2 right = null;
	
	TreeNode2(){}
	TreeNode2(int n){
		this.n = n;
	}
}
