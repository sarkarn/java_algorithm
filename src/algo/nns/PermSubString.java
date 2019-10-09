package algo.nns;

public class PermSubString {

	public void substring(String str, StringBuffer appendString ) {
		
		
		for(int i=str.length()-1; i >=0; i--) {
			String s = str.substring(0, str.length() - 1);
			char c = str.charAt(str.length()-1);
			appendString.append(c);
			
			substring(s,appendString);
		}
		
		
	}
}
