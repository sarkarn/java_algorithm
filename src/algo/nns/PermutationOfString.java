package algo.nns;

public class PermutationOfString {
	
	public static void main(String args[]) {
		permutation("abcd","");
	}

	public static void permutation(String str, String choice) {
			
		if(str.length()==0) {
			System.out.println(choice);
		}
		
		for(int i = 0; i<str.length();i++) {
			
			char tempChoice = str.charAt(i);
			choice = choice+tempChoice;
			
			str = str.substring(0,i)+str.substring(i+1, str.length());
			permutation(str, choice);
			
		
			str = str.substring(0,i)+tempChoice+str.substring(i, str.length());
            choice = new StringBuilder(choice).deleteCharAt(choice.length()-1).toString();			
		}
	}
}
