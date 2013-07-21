import acm.program.*;

public class Comma extends ConsoleProgram {
	public void run() {
		while(true) {
			String digits = readLine("Enter a number: ");
			if(digits.length() == 0) break;
			println(addComma(digits));
		}
	}
	
	private String addComma(String digitsString) {
		// Find the number of commas in the number
		int commaCount = (digitsString.length() - 1) / 3;
		if(commaCount == 0) return digitsString;
		
		int firstCommaIndex = (digitsString.length() % 3 != 0 ? digitsString.length() % 3 : 3); // Find the index of the first comma

		String aString = "";
		aString = digitsString.substring(0,firstCommaIndex) + ","; // Get the substring from first digit to the digit before first comma

		/* Concat aString with a comma to the returning string */
		for(int i = 0 ; i < commaCount - 1 ; i++){
			aString += digitsString.substring(firstCommaIndex + i * 3, firstCommaIndex + i * 3 + 3);
			aString += ",";
		}
		aString += digitsString.substring(digitsString.length() - 3, digitsString.length()); // Add the last comma
		return aString;
	}
}
