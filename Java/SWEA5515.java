import java.util.Scanner;

public class SWEA5515 {
	public static int[] d = {31,29,31,30,31,30,31,31,30,31,30};
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int a = sc.nextInt();
            int b = sc.nextInt();
            int cnt = b;
            for(int i=1;i<a;i++){
            	cnt+=d[i-1];
            }
			int ans = cnt%7+3;
            System.out.printf("#%d %d%n",test_case,ans%7);
		}
	}
}
