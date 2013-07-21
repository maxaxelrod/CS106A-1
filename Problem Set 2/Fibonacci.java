import acm.program.*;

public class Fibonacci extends ConsoleProgram {

	private static final long serialVersionUID = 1L;
	/* Maximum value for Fibonacci term */
	private static final int MAX_TERM_VALUE = 10000;
	
	public void run() {	
		int term = 0;
		int nextTerm = 1;
		int tempTerm;
		println("This program lists the Fibonacci sequence.");
		while( term <= MAX_TERM_VALUE) {
			if(term > MAX_TERM_VALUE) break;
			println(term);
			tempTerm = term;
			term = nextTerm;
			nextTerm = term + tempTerm;;
		}
	}
	
	
}
