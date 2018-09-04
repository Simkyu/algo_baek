package algo_baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

// 트리순회 : 성공
public class pb1991 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(BR.readLine());
		
		String[] temp;
		String s = "";
		// 트리의 위치, root의 위치
		int temp1, temp2, z=0;
		int j = 0;
		
		// 트리들을 링크드리스트에 저장
		LinkedList<TreeNode> tn = new LinkedList<TreeNode>();
		
		
		TreeNode root = new TreeNode();
		
		for(int i = 0; i < N ; ++i) {
			
			temp = BR.readLine().split(" ");
			// N이 26까지 들어오기 때문에 temp1,2에 30으로 초기화한다.
			temp1 = 30;
			temp2 = 30;
			
			
			// "."이 아닌 문자가 들어올 경우
			if(!temp[1].equals(".")) {
				// 리스트를 순회하여 있으면 위치(j)를 temp1에 저장한다.
				// 리스트에 없다면 새로 추가해주고 해당 위치를 temp1에 저장한다.
				for(j = 0; j < tn.size() ; ++j) {
					if(tn.get(j).c.equals(temp[1])) {
						temp1 = j;
						break;
					}
				}
				if(temp1 == 30) {
					temp1 = tn.size();
					tn.add(new TreeNode(temp[1]));
				}
			}
			// 위와 같다.
			if(!temp[2].equals(".")) {
				for(j = 0; j < tn.size() ; ++j) {
					if(tn.get(j).c.equals(temp[2])) {
						temp2 = j;
						break;
					}
				}
				if(temp2 == 30) {
					temp2 = tn.size();
					tn.add(new TreeNode(temp[2]));
				}
			}
			
			// 순회하여 노드가 있으면 mid가 되어 트리의 자식들과 연결한다.
			for(j = 0; j < tn.size() ; ++j) {
				if(tn.get(j).c.equals(temp[0])) {
					TreeNode mid = tn.get(j);
					// root를 위해서 설정한다.
					if(i==0) {
						z = j;
					}
					
					if(temp1 != 30) {
						mid.setLeft(tn.get(temp1));
					} 
					if (temp2 != 30) {
						mid.setRight(tn.get(temp2));
					}
					break;
				}
			}
			// 순회했을때 없다면 mid 노드를 생성한다.
			if(j == tn.size()) {
				TreeNode mid = new TreeNode(temp[0]);
				if(i==0) {
					z = j;
				}
				
				if(temp1 != 30) {
					mid.setLeft(tn.get(temp1));
				} 
				if (temp2 != 30) {
					mid.setRight(tn.get(temp2));
				}
				
				tn.add(mid);
			}
		}
		
		root.setLeft(tn.get(z));
			
		root.PreOrder(root.left);
		System.out.println();
		root.InOrder(root.left);
		System.out.println();
		root.PostOrder(root.left);
		
		}
	}


class TreeNode {
	TreeNode left = null;
	TreeNode right = null;
	String c;
	
	TreeNode(TreeNode left, TreeNode right, String c){
		this.left = left;
		this.right = right;
		this.c = c;
	}
	TreeNode(String c){
		this.c = c;
	}
	TreeNode(){}
	
	void setLeft(TreeNode node) {
		this.left = node;
	}

	void setRight(TreeNode node) {
		this.right = node;
	}
	
	void PreOrder(TreeNode TreeNode) {
		printTreeNode(TreeNode);
		if(TreeNode.left != null) {
			PreOrder(TreeNode.left);
		}
		
		if(TreeNode.right != null) {
			PreOrder(TreeNode.right);
		}
	}
	void PostOrder(TreeNode TreeNode) {
		if(TreeNode.left != null) {
			PostOrder(TreeNode.left);
		}
		if(TreeNode.right != null) {
			PostOrder(TreeNode.right);
		}
		printTreeNode(TreeNode);
	}
	void InOrder(TreeNode TreeNode) {
		
		if(TreeNode.left != null) {
			InOrder(TreeNode.left);
		}
		printTreeNode(TreeNode);
		if(TreeNode.right != null) {
			InOrder(TreeNode.right);
		}
	}
	
	void printTreeNode(TreeNode TreeNode) {
		System.out.print(TreeNode.c);
	}
}
