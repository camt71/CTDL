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
		if (c >= 65 && c <= 90) {
			return ALPHABET[(c + n) % 26];
		} else {
			return (char) ('0' + c);

		}
	}

	public String encrypt(String input) {
		String res = "";
		for (int i = 0; i < input.length(); i++) {
			res += encryptChar(input.charAt(i));

		}
		return res;
	}

	public char decryptChar(char c) {
		if (c >= 65 && c <= 90) {
			return ALPHABET[(c - n) % 26];
		} else {
			return (char) ('0' - c);

		}
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
