import java.util.Scanner;

public class 백준2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a=0;
		int b=0;
		
		while(true) {
			int cal= n-3*a;
			if(cal<0) {
				System.out.println(-1);
				break;
			}
			if(cal==0) {
				System.out.println(a);
				break;
			}
			if(cal%5==0) {
				b = cal/5;
				System.out.println(a+b);
				break;
			}
			else
				a++;
		}
	}
}
