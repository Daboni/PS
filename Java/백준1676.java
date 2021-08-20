import java.util.Scanner;

public class 백준1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();

		int k = n/25;
		int s = k/5;
		
		System.out.println(n==0?0:n/5+k+s);
		
	}
}