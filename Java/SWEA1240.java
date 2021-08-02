import java.util.ArrayList;
import java.util.Scanner;

public class SWEA1240 {
	
	public static String[] code = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111",
			"0111011","0110111","0001011"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			char[] d = new char[m];
			boolean ok = false;
			for(int i=0;i<n;i++) {
				String s = sc.next();
				if(ok) continue;
				for(int j=0;j<m;j++) {
					d[j] = s.charAt(j);
					if(d[j]=='1') ok=true;
				}
			}
			char[] d2 = new char[56];
			int j=0;
			for(int i=d.length-1;i>=0;i--) {
				if(d[i]=='1') {
					j=i;
					break;
				}
			}
			for(int i=55;i>=0;i--) {
				d2[i] = d[j--];
			}
			int res = 0;
			ArrayList<Integer> decode = new ArrayList<Integer>();
			for(int i=0;i<56;i+=7) {
				String s = "";
				for(int k=i;k<i+7;k++) {
					s+=d2[k];
				}
				for(int it=0;it<10;it++) {
					if(s.equals(code[it])) decode.add(it);
				}
			}
			for(int i=0;i<8;i++) {
				if(i%2==0) res += (decode.get(i)*3);
				else
					res += decode.get(i);
			}
			if(res%10!=0) res = 0;
			else {
				res =0;
				for(int x:decode) {
					res += x;
				}
			}
			System.out.printf("#%d %d%n",tc,res);
		}
	}
}
