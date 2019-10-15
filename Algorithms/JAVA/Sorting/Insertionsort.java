package Lect5;

import java.util.Scanner;

public class Insertionsort {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array = takeinput();
		sort(array);

	}

	public static int[] takeinput() {
		System.out.println("Size?");
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static void sort(int[] arr) {
		int i, j, k, temp;
		for (i = 1; i < arr.length; i++) {
			j = i - 1;
			temp = arr[i];
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
		for (k = 0; k < arr.length; k++)
			System.out.print(arr[k] + " ");
	}
}

