import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			a.add(i);
		}
		int j=0;
		while(a.size()>0) {
			j+=(k-1);
			if(j>=a.size()) j %= a.size();
			ans.add(a.get(j));			
 			a.remove(j);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0;i<n;i++) {
			sb.append(ans.get(i)+", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}
