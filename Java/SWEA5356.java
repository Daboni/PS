import java.util.Scanner;

public class SWEA5356 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String[] a = new String[5];
			
			int max = 0;
			for(int i=0;i<5;i++) {
				a[i] = sc.next();
				max = Math.max(max, a[i].length());
			}
			StringBuilder st = new StringBuilder();
			st.append("#"+tc+" ");
			for(int i=0;i<max;i++) {
				for(int j=0;j<5;j++) {
					if(a[j].length()<=i) {
						continue;
					}
					st.append(a[j].charAt(i));
				}
			}
			System.out.println(st.toString());
		}
	}
}
