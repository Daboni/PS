import java.util.Scanner;

public class SWEA9700 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			double p = sc.nextDouble();
			double q = sc.nextDouble();
			
			double s0 = p*q;
			double s1 = (1-p)*q;
			double s2 = p*(1-q)*q;
			if(s1<s2)
				System.out.printf("#%d YES%n",tc);
			else
				System.out.printf("#%d NO%n",tc);
			
		}
	}
}
