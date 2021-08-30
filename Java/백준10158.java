import java.util.Scanner;

public class 백준10158 {
	
	static int[] dx= {1,-1,1,-1};
	static int[] dy= {1,1,-1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int t = sc.nextInt();

		
		int dw = t%(2*w);
		int dh = t%(2*h);
		
		boolean right = true;
        while(dw-->0) {
            if(x == 0) right = true;
            if(x == w) right = false;
            
            if(right) x++;
            else x--;
        }
        
        boolean up = true;
        while(dh-->0) {
            if(y == 0) up = true;
            if(y == h) up = false;
            
            if(up) y++;
            else y--;
        }
        
		System.out.println(x+" "+y);
	}
}
