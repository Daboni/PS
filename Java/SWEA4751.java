import java.util.Scanner;

public class SWEA4751 {
	
	public static String[] s1 = {"..#.","..#.."};
	
	public static String[] s2 = {".#.#",".#.#."};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while(T-->0) {
			String s = sc.next();
			int n = s.length();
			for(int i=0;i<5;i++) {
				for(int j=0;j<n;j++) {
					if(i==0 || i== 4) {
						if(j==n-1) {
							System.out.printf("%s%n",s1[1]);
							continue;
						}
						System.out.printf("%s",s1[0]);
					}
					else if(i==1 || i== 3) {
						if(j==n-1) {
							System.out.printf("%s%n",s2[1]);
							continue;
						}
						System.out.printf("%s",s2[0]);
					}
					else {
						if(j==n-1) {
							System.out.printf("#.%c.#%n",s.charAt(j));
							continue;
						}
						System.out.printf("#.%c.",s.charAt(j));
					
					}
				}
			}
		}
	}
}
