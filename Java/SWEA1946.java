import java.util.Scanner;

public class SWEA1946 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			
			String s="";
			int n = sc.nextInt();
			
			for(int i=0;i<n;i++) {
				String c = sc.next();
				int k = sc.nextInt();
				
				for(int j=0;j<k;j++)
					s+=c;	
			}
			System.out.printf("#%d%n",tc);
			
			for(int i=0;i<s.length();i++) {
				if(i!=0 && i%10==0) System.out.println();
				System.out.print(s.charAt(i));
			}
			System.out.println();
		}
		
	}
}
