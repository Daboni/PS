import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		int TLen = T.length;
		int PLen = P.length;
		
		int[] pi = new int[PLen];
		int j = 0;
		for(int i=1;i<PLen;i++) {
			
			while(j>0 && P[i]!=P[j]) j=pi[j-1];
			
			if(P[i]==P[j]) pi[i] = ++j;
			
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		j =0;
		for(int i=0;i<TLen;i++) {
		
			while(j>0 && T[i]!=P[j]) j =pi[j-1];
			
			if(T[i]==P[j]) {
				if(j==PLen-1) {
					cnt++;
					list.add(i-PLen+2);
					j = pi[j];
				}else {
					j++;
				}
			}
			
		}
		System.out.println(cnt);
		if(cnt>0) {
			for(Integer x:list)
				System.out.print(x+" ");
		}
	}
}
