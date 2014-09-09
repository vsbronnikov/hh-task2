package org.vsbronnikov.hh.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.vsbronnikov.hh.Finder;
import org.vsbronnikov.hh.Sequence;
import org.vsbronnikov.hh.SerialSequence;

public class SerialSequenceTestCase {

	@Test
	public void test6789() {
		Sequence<String> s = new SerialSequence();
		Finder finder = new Finder("6789");

		while (!finder.isDone()) {
			finder.find(s.next());
		}

		assertEquals(6, finder.getResult());
	}

	@Test
	public void test101() {
		Sequence<String> s = new SerialSequence();
		Finder finder = new Finder("101");

		while (!finder.isDone()) {
			finder.find(s.next());
		}

		assertEquals(10, finder.getResult());
	}
}
