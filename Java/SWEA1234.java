import java.util.Scanner;

public class SWEA1234 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int k = sc.nextInt();
			String s = sc.next();
			
			while(true) {
				int cur =0;
				int next = 1;
				int n = s.length();
				String tmp = "";
				for(;cur<n;cur++) {
					if(cur==n-1) {
						tmp+=s.charAt(cur);
						break;
					}
					next = cur+1;
					if(s.charAt(cur)==s.charAt(next)) cur++;
					else {
						tmp += s.charAt(cur);
					}
				}
				if(s.equals(tmp)) break;
				s=tmp;
			}
			System.out.printf("#%d %s%n",t,s);
		}
	}
}
