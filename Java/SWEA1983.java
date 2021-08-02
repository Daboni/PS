import java.util.Arrays;
import java.util.Scanner;

public class SWEA1983 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] d = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			k-=1;
			double tar = 0;
			double[] scores = new double[n];
			
			for(int i=0;i<n;i++) {
				double score = 0;
				
				double mid = sc.nextDouble();
				double fin = sc.nextDouble();
				double sub = sc.nextDouble();
				score = mid*0.35 + fin*0.45 + sub*0.2;
				
				scores[i] = score;
				if(i==k) tar = score;
			}
			int num=0;
			Arrays.sort(scores);
			for(int i=n-1;i>0;i--) {
				if(scores[i]==tar) break;
				num++;
			}
			System.out.printf("#%d %s%n",tc,d[num/(n/10)]);
		}
	}
}
