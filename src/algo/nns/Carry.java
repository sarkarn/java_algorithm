package algo.nns;

public class Carry {

	public static void main(String args[]) {
		
		int a =100;
		int b = 325;
		
		while( b !=0) {
			//find out the carry
			int carry = a&b;
			
			//add the number without carry
			a = a ^ b;
			
			b = carry<<1;
		}
		
		System.out.println(a);
		
		
	}
}
