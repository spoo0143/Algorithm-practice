package com.bridgelabz.algorithm;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {

		int result = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Path for file: ");
		String filePath = sc.next();
		System.out.println("Enter Name of the File: ");
		String fileName = sc.next();
		List<String> list = new ArrayList<>();
		List<String> tempList = new ArrayList<>();
		System.out.println("Enter Words: ");

		int i = 0;
		while (i < 5) {
			String words = sc.next();
			list.add(words);
			i++;
		}
		Collections.sort(list);
		System.out.println(list);

		System.out.println("Enter Word to Search");
		String toSearch = sc.next();

		try {
			String lines;
			File file = new File(filePath + fileName);
			boolean isCreated = file.createNewFile();
			System.out.println(list);
			FileWriter fileWriter = new FileWriter(file);

			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			// String isFetching = bufferedReader.readLine();

			if (isCreated) {

				// for(String str: list)
				// {
				fileWriter.write(list + System.lineSeparator());

				// }

				System.out.println("File Created Successfully...!!!");
				fileWriter.close();
				lines = bufferedReader.readLine();
				while (lines != null) {
					// result = Collections.binarySearch(list, toSearch);
					tempList.add(lines);
					lines = bufferedReader.readLine();
					System.out.println(tempList);

				}

			} else
				System.out.println("Already Present in the destination");
		} catch (Exception e) {
			System.out.println("Exception Occured: ");
			e.printStackTrace();
		}

		// reading from file...
		System.out.println("Temporary List: " + tempList);
		result = Collections.binarySearch(tempList, toSearch);
		if (result != -1)
			System.out.println("Element found at index " + result);
		else
			System.out.println("Not Found");

	}
}
