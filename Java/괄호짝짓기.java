import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int n = sc.nextInt();
			
			Stack<Character> st1 = new Stack<Character>();
			Stack<Character> st2 = new Stack<Character>();
			Stack<Character> st3 = new Stack<Character>();
			Stack<Character> st4 = new Stack<Character>();
			
			String s = sc.next();
			int ans = 1;
			for(int i=0;i<n;i++) {
				char c = s.charAt(i);
				if(c=='(') st1.push(c);
				if(c=='[') st2.push(c);
				if(c=='{') st3.push(c);
				if(c=='<') st4.push(c);
				
				if(c==')') {
					if(st1.isEmpty()) {
						ans=0;
						break;
					}
					else {
						st1.pop();
					}
				}
				if(c==']') {
					if(st2.isEmpty()) {
						ans=0;
						break;
					}
					else {
						st2.pop();
					}
				}
				if(c=='}') {
					if(st3.isEmpty()) {
						ans=0;
						break;
					}
					else {
						st3.pop();
					}
				}
				if(c=='>') {
					if(st4.isEmpty()) {
						ans=0;
						break;
					}
					else {
						st4.pop();
					}
				}
				
			}
			System.out.printf("#%d %d%n",tc,ans);
			
			
		}
	}
}
