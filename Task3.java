package lab1;

public class Task3 {
	public static String encrypt(String text, int n) {
		String res = "";
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if ((int) ch >= 65 && (int) ch <= 90 || (int) ch >= 48 && (int) ch <= 57
					|| (int) ch >= 97 && (int) ch <= 122) {
				res += (char) (ch + n);
			} else {
				res += (char) ch;
			}
		}
		return res;
	}

	public static String decrypt(String text, int n) {
		String res = "";
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if ((int) ch >= 65 && (int) ch <= 90 || (int) ch >= 48 && (int) ch <= 57
					|| (int) ch >= 97 && (int) ch <= 122) {
				res += (char) (ch - n);
			} else {
				res += (char) ch;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String text = "Hello 2023";
		System.out.println(encrypt(text, 3));
		System.out.println(decrypt(encrypt(text, 3), 3));
	}
}
