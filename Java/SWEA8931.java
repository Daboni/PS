import java.util.Scanner;
import java.util.Stack;

public class SWEA8931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			Stack<Integer> st = new Stack<Integer>();
			
			int n=sc.nextInt();
			for(int i=0;i<n;i++) {
				int k = sc.nextInt();
				if(k==0) st.pop();
				else st.add(k);
			}
			int ans =0;
			for(int x:st) ans+=x;
			System.out.printf("#%d %d%n",tc,ans);
		}
	}
}
