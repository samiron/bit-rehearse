package of.samiron.fb;

public class RotationalCipher {
	// Add any helper functions you may need here

	int nAlphabets = 26;
	int nNums = 10;


	String rotationalCipher(String input, int rotationFactor) {

		StringBuilder sb = new StringBuilder();
		for(char ch : input.toCharArray()){
			sb.append(rotate(ch, rotationFactor));
		}
		return sb.toString();
	}

	char rotate(char ch, int rotationFactor) {
		int nRotations = 0;

		if(alphaUpcase(ch)) {
			nRotations = rotationFactor % nAlphabets;
			ch = (char) (ch + nRotations);
			return ch > 'Z' ? (char) ('A' + (ch - 'Z' - 1)) : ch;

		} else if (alphaSmallcase(ch)) {
			nRotations = rotationFactor % nAlphabets;
			ch = (char) (ch + nRotations);
			return ch > 'z' ? (char) ('a' + (ch - 'z' - 1)) : ch;

		} else if (num(ch)) {
			nRotations = rotationFactor % nNums;
			ch = (char) (ch + nRotations);
			return ch > '9' ? (char) ('0' + (ch - '9' - 1)) : ch;

		} else {
			return ch;

		}
	}

	boolean alphaUpcase(char ch) {
		return ch >= 'A' &&  ch <= 'Z';
	}

	boolean alphaSmallcase(char ch) {
		return ch >= 'a' && ch <= 'z';
	}

	boolean num(char ch) {
		return ch >= '0' && ch <= '9';
	}


	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom.
	int test_case_number = 1;
	void check(String expected, String output) {
		boolean result = (expected.equals(output));
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		}
		else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printString(expected);
			System.out.print(" Your output: ");
			printString(output);
			System.out.println();
		}
		test_case_number++;
	}
	void printString(String str) {
		System.out.print("[\"" + str + "\"]");
	}

	public void run() {
		String input_1 = "All-convoYs-9-be:Alert1.";
		int rotationFactor_1 = 4;
		String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
		String output_1 = rotationalCipher(input_1, rotationFactor_1);
		check(expected_1, output_1);

		String input_2 = "abcdZXYzxy-999.@";
		int rotationFactor_2 = 200;
		String expected_2 = "stuvRPQrpq-999.@";
		String output_2 = rotationalCipher(input_2, rotationFactor_2);
		check(expected_2, output_2);

		// Add your own test cases here
		String input_3 = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
		int rotationFactor_3 = 39;
		String expected_3 = "nopqrstuvwxyzABCDEFGHIJKLM9012345678";
		String output_3 = rotationalCipher(input_3, rotationFactor_3);
		check(expected_3, output_3);

		String input_4 = "Zebra-493?";
		int rotationFactor_4 = 3;
		String expected_4 = "Cheud-726?";
		String output_4 = rotationalCipher(input_4, rotationFactor_4);
		check(expected_4, output_4);

		String input_5 = "abcdefghijklmNOPQRSTUVWXYZ";
		int rotationFactor_5 = 999999 ;//39;
		String expected_5 = "nopqrstuvwxyzABCDEFGHIJKLM";
		String output_5 = rotationalCipher(input_5, rotationFactor_5);
		check(expected_5, output_5);


	}

	public static void main(String[] args) {
		new RotationalCipher().run();
		//System.out.println((char) ('a' + 2));

	}
}
