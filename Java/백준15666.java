import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class 백준15666 {
	
	public static int n;
	public static int m;
	public static int[] a;
	public static LinkedHashSet<String> map;
	public static int[] tmp;
	
	public static StringBuilder sb;
	public static void go(int idx,int cnt) {
		
		if(cnt == m){
			sb = new StringBuilder();
			
			for(int i=0;i<m;i++){
				sb.append(tmp[i]+" ");
			}
			map.add(sb.toString());
			return;
		}
		if(idx == n) return;
		
		for(int i=idx;i<n;i++) {
			tmp[cnt] = a[i];
			go(i,cnt+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		a = new int[n];
		map = new LinkedHashSet<>();
		tmp = new int[m];
		
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);		
		
		go(0,0);
		
		for(String s : map) {
			System.out.println(s);
		}
	}
}
