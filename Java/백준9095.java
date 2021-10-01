import java.util.Scanner;

public class 백준9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		int[] d = new int[12];
		d[0] = 1;
		for(int tc=0;tc<t;tc++) {
			
			int n = sc.nextInt();
			if(d[n]!=0) {
				System.out.println(d[n]);
				continue;
			}
			for(int i=1;i<=n;i++) {
				
				d[i] = d[i-1];
				if(i>=2) d[i] += d[i-2];
				if(i>=3) d[i] += d[i-3];
				
			}
			System.out.println(d[n]);
		}
	}
}
