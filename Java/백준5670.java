import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준5670 {
	public static final int ALPHA_SIZE = 26;
	
	public static int n;
	public static Trie trie;
	
	public static double ans;
	public static String[] strings;
	
	public static class Trie{
		Node root;
		
		public Trie() {
			this.root = new Node();
			root.val = ' ';
		}
		
		public int char2int(char c) {
			return c-'a';
		}
		public void insert(String s) {
			int length = s.length();
			Node current = this.root;
			
			for(int i=0;i<length;i++) {
				char c = s.charAt(i);
				int num = char2int(c);
				
				if(current.child[num] == null) {
					current.child[num] = new Node();
					current.child[num].val = c;
					current.childNum++;
				}
				current = current.child[num];
			}
			current.isLastChar = true;
		}
	}
	public static class Node{
		Node[] child = new Node[ALPHA_SIZE];
		boolean isLastChar = false;
		char val;
		int childNum;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = "";
		while((s = br.readLine()) != null) {
			
			n = Integer.parseInt(s);
			trie = new Trie();
			strings = new String[n];
			
			for(int i=0;i<n;i++) {
				strings[i] = br.readLine(); 
				trie.insert(strings[i]);
			}
			
			ans = 0;
			
			for(String str : strings) {
				ans += find(str);
			}
			System.out.printf("%.2f%n",ans/n);
			
		}
	}
	public static double find(String s) {
		
		int length = s.length();
		Node cur = trie.root;
		
		char c = s.charAt(0);
		int num = trie.char2int(c);	
		
		cur = cur.child[num];
		
		double cnt = 1;
		
		for(int i=1;i<length;i++) {
			c = s.charAt(i);
			num = trie.char2int(c);	
			
			if(cur.childNum>=2) cnt++;
			if(cur.childNum==1 && cur.isLastChar) cnt++;
			
			cur = cur.child[num];
			
		}
		return cnt;
	}
}
