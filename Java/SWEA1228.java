import java.util.ArrayList;
import java.util.Scanner;

public class SWEA1228 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int n = sc.nextInt();
			ArrayList<Integer> a = new ArrayList<Integer>();
			for(int i=0;i<n;i++) {
				a.add(sc.nextInt());
			}
			int cnt = sc.nextInt();
			while(true) {
				if(cnt<=0) break;
				sc.next();
				int idx = sc.nextInt();
				int num = sc.nextInt();
				for(int i=0;i<num;i++) {
					a.add(idx,sc.nextInt());
					idx++;
				}
				cnt--;
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<10;i++) {
				System.out.printf("%d ",a.get(i));
			}
		}
	}
}
