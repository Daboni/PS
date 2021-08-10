import java.util.Scanner;

public class 사칙연산유효성검사 {
	static String[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			
			tree = new String[n+1];
			
			boolean ok = n%2==1?true:false;
			
			for(int i=1;i<=n;i++) {
				
				int k = sc.nextInt();
				tree[k] = sc.next();
				if(k*2+1<=n) {
					if(!tree[k].equals("*") && !tree[k].equals("+") 
							&& !tree[k].equals("/") && !tree[k].equals("-")) {
						ok = false;
					}
				}
				else {
					if(tree[k].equals("*") || tree[k].equals("+") 
							|| tree[k].equals("/") || tree[k].equals("-")) {
						ok = false;
					}
				}
				if(k*2<=n) tree[k*2] = sc.next();
				if(k*2+1<=n) tree[k*2+1] = sc.next();
			}
			System.out.printf("#%d %d%n",tc,ok==true?1:0);
			
		}
	}
}
