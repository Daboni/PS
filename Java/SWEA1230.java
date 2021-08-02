import java.util.ArrayList;
import java.util.Scanner;

public class SWEA1230 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			
			ArrayList<Integer> a = new ArrayList<Integer>();
			for(int i=0;i<n;i++) 
				a.add(sc.nextInt());
			
			int m = sc.nextInt();
			
			for(int i=0;i<m;i++) {
				String c = sc.next();
				if(c.equals("I")) {
					int num = sc.nextInt();
					int cnt = sc.nextInt();
					for(int j=0;j<cnt;j++) {
						a.add(num++, sc.nextInt());
					}
				}
				if(c.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int j=0;j<y;j++) {
						a.remove(x);
					}
				}
				if(c.equals("A")) {
					int y = sc.nextInt();
					for(int j=0;j<y;j++) {
						a.add(sc.nextInt());
					}
				}
			}
			System.out.printf("#%d ",tc);
			for(int i=0;i<10;i++) {
				System.out.print(a.get(i)+" ");
			}
			System.out.println();
		}
		
	}
}
