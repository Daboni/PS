import java.util.Arrays;
import java.util.Scanner;

public class SWEA10912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			char[] s = sc.next().toCharArray();
			
			for(int i=0;i<s.length;i++) {
				char c = s[i];
				if(c=='\0') continue;
				for(int j=i+1;j<s.length;j++) {
					if(s[j]=='\0') continue;
					if(c == s[j]) {
						s[i] = '\0';
						s[j] = '\0';
						break;
					}
				}
			}
			Arrays.sort(s);
			String ans ="";
			for(int i=0;i<s.length;i++) {
				if(s[i]=='\0') continue;
				ans+=s[i];
			}
			if(ans.equals("")) System.out.printf("#%d %s%n",tc,"Good");
			else System.out.printf("#%d %s%n",tc,ans);
		}
	}
}
