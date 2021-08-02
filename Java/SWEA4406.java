import java.util.Scanner;

public class SWEA4406 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			
			String s = sc.next();
			String ans = "";
			
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') continue;
				ans+=c;
			}
			System.out.printf("#%d %s%n",tc,ans);
			
		}
		
	}
}
