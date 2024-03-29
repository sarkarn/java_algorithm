package algo.nns;

public class PrintParenthesis {

	public static void printPar(int l, int r, char[] str, int count) {
		if(l<0 || r<l) {
			return;
		}
		if(l==0 && r==0) {
			for(char c: str) {
				System.out.print(c);
			}
		}else {
			if(l>0) {
				str[count] = '(';
				printPar(l-1,r,str,count+1);
			}
			if(r>l) {
				str[count] = ')';
				printPar(l,r-1,str,count+1);
			}
		}
	}
	

	public static void printPar(int count) {
		char[] str = new char[count*2];
		printPar(count,count, str, 0);
	}
	
	public static void main(String args[]) {
		printPar(2);
	}
			

}
