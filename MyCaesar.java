package lab1;

//task 2
public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

//array
	public char encryptChar(char c) {
		int res = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				res = i;
			}
		}

		if (res + n > 25) {
			return ALPHABET[n - (24 - res) - 1];
		} else
			return ALPHABET[(res + n) % 26];

	}

	public String encrypt(String input) {
		String res = "";
		for (int i = 0; i < input.length(); i++) {
			res += encryptChar(input.charAt(i));

		}
		return res;
	}

	
	public char decryptChar(char c) {
		int res = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				res = i;
			}
		}
		if (res - n < 0) {
			return ALPHABET[(24 - n) + res + 1];
		} else
			return ALPHABET[(res - n) % 26];
	}


	public String decrypt(String input) {
		String res = "";
		for (int i = 0; i < input.length(); i++) {
			res += decryptChar(input.charAt(i));
		}
		return res;
	}

	public static void main(String[] args) {
		MyCaesar caesar = new MyCaesar(3);
		System.out.println(caesar.encryptChar('D'));
		System.out.println(caesar.decryptChar('T'));
		System.out.println(caesar.encrypt("HELLO"));
		System.out.println(caesar.decrypt(caesar.encrypt("HELLO")));
	}
}
