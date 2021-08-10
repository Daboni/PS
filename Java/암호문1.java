import java.util.ArrayList;
import java.util.Scanner;

public class 암호문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=10;
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			ArrayList<Integer> a = new ArrayList<Integer>();
			
			for(int i=0;i<n;i++)
				a.add(sc.nextInt());
			
			int m = sc.nextInt();
			
			for(int i=0;i<m;i++) {
				sc.next();
				int idx = sc.nextInt();
				int j = sc.nextInt();
				for(int k=0;k<j;k++) {
					a.add(idx,sc.nextInt());
					idx++;
				}
			}
			System.out.printf("#%d ",tc);
			for(int i=0;i<10;i++) {
				System.out.printf("%d ",a.get(i));
			}
			System.out.println();
		}
	}
}
