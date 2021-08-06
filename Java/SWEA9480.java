import java.util.Scanner;

public class SWEA9480 {
	public static int n;
	public static String[] voca;
	
	public static void go(int idx, int[] alphas) {
		
		if(idx == n) return;
		
		for(int i=0;i<='z'-'a';i++) {
			
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			n = sc.nextInt();
			voca = new String[n];
			for(int i=0;i<n;i++)
				voca[i] = sc.next();
			
			
		}
	}
}
