import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class 백준1270 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			for(int i=0;i<n;i++) {
				int k = sc.nextInt();
				if(m.get(k)==null) m.put(k, 1);
				else m.put(k,m.get(k)+1);
			}
			int ans = 0;
			for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
				  int key = entry.getKey();
				  int val = entry.getValue();
				  if(val>n/2) ans = key;
			}
			if(ans==0)
				System.out.println("SYJKGW");
			else
				System.out.println(ans);
			
		}
	}
}
