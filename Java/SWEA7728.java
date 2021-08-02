import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SWEA7728 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			Set<Integer> s = new HashSet<Integer>();
			while(n>0) {
				s.add(n%10);
				n/=10;
			}
			System.out.printf("#%d %d%n",tc,s.size());
		}
	}
}
