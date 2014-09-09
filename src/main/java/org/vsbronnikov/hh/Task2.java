package org.vsbronnikov.hh;

import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String A = (String) in.nextLine();
		in.close();

		long start = System.currentTimeMillis();

		Sequence<String> s = new SerialSequence();
		Finder finder = new Finder(A);

		while (!finder.isDone()) {
			finder.find(s.next());
		}

		long end = System.currentTimeMillis();

		System.out.println(finder.getResult());
		System.out.println("Elapsed time: " + (end - start));
	}

}
