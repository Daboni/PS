import java.util.Scanner;

public class 퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			
			String[] a = new String[n];
			
			for(int i=0;i<n;i++) {
				a[i] = sc.next();
			}
			System.out.printf("#%d ",tc);
			for(int i=0;i<=(n-1)/2;i++) {
				System.out.printf("%s ",a[i]);
				if((n-1)/2+i+1<n) {
					System.out.printf("%s ",a[(n-1)/2+i+1]);					
				}
				
			}
			System.out.println();
		}
	}
}
