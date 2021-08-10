import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SWEA10804 {
		
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		Map<Character, Character> hm = new HashMap<>();
		hm.put('b','d');
		hm.put('d','b');
		hm.put('q','p');
		hm.put('p','q');
		
		for(int tc=1;tc<=T;tc++) {
			String s = sc.next();
			String tmp= "";
			for(int i=s.length()-1;i>=0;i--) {
				tmp += hm.get(s.charAt(i));
			}
			System.out.println("#"+tc+" "+tmp);
		}
	}
}
