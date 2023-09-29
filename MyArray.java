package lab1;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

//task 1.1
	public int[] mirror(int[] arr) {
		int[] res = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
			res[res.length - i - 1] = arr[i];
		}
		return res;
	}

	// kiem tra phan tu trung
	public static boolean check(int[] arr, int value) {
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == value)
				return true;
		}
		return false;
	}

	// bien dem
	public int count() {
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					count++;
				}
			}
		}
		return count;
	}

	// xoa phan tu trung
	public int[] removeDuplicates() {
		int index = 0;
		int[] res = new int[array.length - count()];
		for (int i = 0; i < array.length; i++) {
			if (!check(res, array[i])) {
				res[index++] = array[i];
			}
		}
		return res;

	}

//task 1.2
	// bien dem phan tu bi thieu
	public int countGet(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i + 1] - array[i] == 2)
				count++;
		}
		return count;
	}

	// lay phan tu thieu
	public int[] getMissingValues(int[] arr) {
		int[] res = new int[countGet(arr)];
		int index = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] == 2)
				res[index++] = arr[i] + 1;
		}
		return res;

	}

//task 1.2
	// check xem co phan tu trong mang khong
	public int indexOf(int[] array, int checkValue) {
		for (int i = 0; i < array.length; i++) {
			if (checkValue == array[i]) {
				return i;
			}
		}
		return -1;
	}

	public int[] fillMissingValues(int k) {
		int[] list = new int[array.length];
		int cur = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i] || array[i] == -1) {
				list[cur++] = i;
				int sum = 0;
				for (int j = 1; j < k / 2 + 1; j++) {
					sum += array[i - j];
					sum += array[i + j];
				}
				if (k % 2 == 1) {
					if (array[i - k / 2 - 1] > array[i + k / 2 + 1] && array[i + k / 2 + 1] != -1) {
						sum += array[i + k / 2 + 1];
					} else if (indexOf(list, i - k / 2 - 1) != -1 && i - k / 2 - 1 != 0) {
						sum += array[i + k / 2 + 1];
					} else
						sum += array[i - k / 2 - 1];
				}
				sum /= k;
				array[i] = sum;
			}
		}
		return array;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
//		int arr[] = { 1, 2, 5, 3, 5, 2, 0 };
		int res[] = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		int arr[] = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		MyArray array = new MyArray(arr);
//		printArray(array.mirror(arr));
//		System.out.println();
//		printArray(array.removeDuplicates());
//		printArray(array.getMissingValues(res));
		printArray(array.fillMissingValues(3));
	}
}
