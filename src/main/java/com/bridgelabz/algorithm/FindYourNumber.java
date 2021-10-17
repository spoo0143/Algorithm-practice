package com.bridgelabz.algorithm;


	import java.util.Scanner;

	public class FindYourNumber {
		int[] numberArray; // array of numbers of given range
		int count = 0;
		int ans; // the number in mind
		int range; // range
		double maxCount = 0; // number of times question will be asked

		void start() {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter limit N: ");
			range = scan.nextInt();

			numberArray = new int[range]; // array initialization

			// fills the array

			for (int i = 0; i < range; i++) {
				numberArray[i] = i;
			}

			// calculates maximum count of questions
			maxCount = (Math.log(range) / Math.log(2));
			System.out.println("Number of tries required to guess: " + ((int) maxCount + 1));
			binarySearch(0, range - 1);
		}

		public static void main(String[] args) {
			FindYourNumber findYourNumber = new FindYourNumber();
			findYourNumber.start();

		}

		void binarySearch(int first, int last) {
			if (count < maxCount) {
				int middle = (first + last) / 2;
				count++;
				Scanner sc = new Scanner(System.in);
				System.out.println("Is number between " + first + " and " + middle + "?");
				String Value = sc.next();
				if (Value.equals("y")) {
					change(middle + 1, last);
					binarySearch(first, middle);
				} else if (Value.equals("n")) {
					change(first, middle);
					binarySearch(middle + 1, last);
				}
			} else {
				for (int i : numberArray) {
					if (i != -1) {
						System.out.println("The number is: " + i);
					}
				}
			}
		}

		/**
		 * replaces all the integer in the array to -1 as the number is not in this
		 * range first - first element in the range last - last element in the range
		 */
		void change(int first, int last) {
			for (int i = first; i <= last; i++) {
				numberArray[i] = -1;
			}
		}

	

}
