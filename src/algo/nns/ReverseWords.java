package algo.nns;

public class ReverseWords {
	
	public static void main(String args[]) {
		
		System.out.println(reverse("He is a good boy."));
	}
	
	
		
	public static String reverse(String sentence) {
		
		String words[] = sentence.split(" ");
		
		int i = 0;
		int j = words.length -1;
		
		while(i <j ) {
			String temp = words[i];
			words[i] = words[j];
			words[j] = temp;
			i++;
			j--;
		}
		
		StringBuilder s = new StringBuilder();
		
		for(String word : words) {
			s.append(word);
			s.append(" ");
		}
		
		return s.toString();
	}

}
