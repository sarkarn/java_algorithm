package algo.nns;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> combString = new ArrayList();
		
		comb("1234",0, 1, combString);
		
		combString.forEach(System.out::println);
		
	}
	
	public static void comb(String number, int index,  int selecLength,  List<String> result) {
		
			while((index+selecLength) <= number.length()) {
				if(index < selecLength) {
					String combNumber = number.substring(index,selecLength);
					result.add(combNumber);
					comb(number,index+1, selecLength, result);
					selecLength++;
				}else {
					break;
				}
			}
			
		}
		

}
