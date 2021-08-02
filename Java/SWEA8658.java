import java.util.Scanner;

public class SWEA8658 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int max = 0;
			int min = 99999999;
			for(int i=0;i<10;i++) {
				int[] d = new int[10];
				int n = sc.nextInt();
				while(n>0) {
					d[n%10]++;
					n/=10;
				}
				int cal = 0;
				for(int j=0;j<10;j++) {
					cal+=(j*d[j]);
				}
				max = Math.max(cal, max);
				min = Math.min(cal, min);
			}
			System.out.printf("#%d %d %d%n",tc,max,min);
		}
		
	}
}
