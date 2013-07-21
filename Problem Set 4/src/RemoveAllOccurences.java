import acm.program.*;

public class RemoveAllOccurences extends ConsoleProgram{
	public void run() {
		String aString = readLine("Enter a sentence: ");
		char ch = '-';
		println(removeAllOccurences(aString, ch));
	}
	
	private String removeAllOccurences(String aString, char ch) {
		String returningString = "";
		for(int i = 0 ; i < aString.length() - 1; i++) {
			if(aString.charAt(i) != ch) returningString += aString.charAt(i);
		}
		return returningString;
	}
}
