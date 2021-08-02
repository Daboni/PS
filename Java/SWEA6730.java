import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA6730 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			
			ArrayList<Integer> a = new ArrayList<Integer>(n);
			ArrayList<Integer> up = new ArrayList<Integer>();
			ArrayList<Integer> down = new ArrayList<Integer>();
			
			up.add(0);
			down.add(0);
			for(int i=0;i<n;i++)
				a.add(sc.nextInt());
			
			int cur = a.get(0);
			for(int i=1;i<n;i++) {
				if(a.get(i)>cur) {
					up.add(a.get(i)-cur);
				}
				else {
					down.add(Math.abs(cur-a.get(i)));
				}
				cur = a.get(i);
			}
			
			Collections.sort(up,Collections.reverseOrder());
			Collections.sort(down,Collections.reverseOrder());
			
			System.out.printf("#%d %d %d%n",tc,up.get(0),down.get(0));
			
			
		}
		
	}
}
