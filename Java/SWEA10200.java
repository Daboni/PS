import java.util.Scanner;

public class SWEA10200 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int max = Math.min(a,b);
            int min = n>(a+b)?0:(a+b)-n;
            System.out.printf("#%d %d %d%n",test_case,max,min);
 
		}
	}
}
