import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = 10;
		while(t>0) {
			int tc = sc.nextInt();
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i=0;i<8;i++){
				q.add(sc.nextInt());
			}
			label1:while(true) {
				
				for(int i=1;i<=5;i++) {
					int a = q.remove();
					if(a-i<=0) {
						q.add(0);
						break label1;
					}
					q.add(a-i);
				}
				
			}
			System.out.print("#"+tc+" ");
			while(!q.isEmpty()) {
				System.out.print(q.remove()+" ");
			}
			t--;
		}
	}
}
