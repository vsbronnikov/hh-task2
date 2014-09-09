package org.vsbronnikov.hh;

public class SerialSequence implements Sequence<String> {

	private int i = 0;

	public String next() {
		return String.valueOf(++i);
	}
}
